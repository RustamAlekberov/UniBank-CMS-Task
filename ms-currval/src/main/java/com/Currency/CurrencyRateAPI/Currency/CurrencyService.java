package com.Currency.CurrencyRateAPI.Currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.transaction.Transactional;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class CurrencyService {
    private final CurrencyRateRepository currencyRateRepository;
    private final CurrencyCheckRepository currencyCheckRepository;

    @Autowired
    public CurrencyService(CurrencyRateRepository currencyRateRepository, CurrencyCheckRepository currencyCheckRepository) {
        this.currencyRateRepository = currencyRateRepository;
        this.currencyCheckRepository = currencyCheckRepository;
    }

     public Double checkCurrency(String val1, String val2) throws ParserConfigurationException, IOException, SAXException {
        Date maxDate = null;
        Double result = null;
        CurrencyCheck currencyCheck = new CurrencyCheck();
        Long check = currencyRateRepository.findCurrCheck();
        if (check == 0d) {
            updateCurrency();
        }

        CurrencyRate currencyRateRepositoryCurrencyValueBy1 = currencyRateRepository.findCurrencyValueBy1(val1);
        CurrencyRate currencyRateRepositoryCurrencyValueBy2 = currencyRateRepository.findCurrencyValueBy2(val2);
        if (currencyRateRepositoryCurrencyValueBy1 != null && currencyRateRepositoryCurrencyValueBy2 != null) {
            maxDate = currencyCheckRepository.findLastDate(currencyRateRepositoryCurrencyValueBy1.getCurrencyCode());
            currencyCheck.setCheckDate(new Date());
            if (maxDate != null) {
                long seconds = (currencyCheck.getCheckDate().getTime()-maxDate.getTime())/1000;

                if (seconds >= 60) {
                    updateCurrency();
                    currencyRateRepositoryCurrencyValueBy1 = currencyRateRepository.findCurrencyValueBy1(val1);
                    currencyRateRepositoryCurrencyValueBy2 = currencyRateRepository.findCurrencyValueBy2(val2);
                }
            }
            currencyCheck.setCurrency(currencyRateRepositoryCurrencyValueBy1.getCurrencyCode());
            currencyCheckRepository.save(currencyCheck);
            result = currencyRateRepositoryCurrencyValueBy1.getCbarCurr() / currencyRateRepositoryCurrencyValueBy2.getCbarCurr();
        } else {
            throw new IllegalStateException("Your Currency is null");
        }
        return result;
    }

    @Transactional
    public String updateCurrency() throws ParserConfigurationException, IOException, SAXException {
        Date today = new Date();
        String d1 = new SimpleDateFormat("dd.MM.yyyy").format(today).toString();
//        List<CurrencyRate> currencyRateList = currencyRateRepository.findAll();
        String URL = "https://www.cbar.az/currencies/" + d1 + ".xml";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(URL);


        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("Valute");
        boolean azncheck = false;
        for (int i = 0; i < nodeList.getLength(); i++) {

           if (!azncheck) {
                CurrencyRate currazn = currencyRateRepository.findCurrencyValueBy1("AZN");
                if (currazn == null) {
                    azncheck = true;
                    currazn = new CurrencyRate();
                    currazn.setCurrencyDate(new Date());
                    currazn.setCurrencyCode("AZN");
                    currazn.setCurrencyName("1 Azərbaycan manatı");
                    currazn.setCbarCurr(1d);
                    currencyRateRepository.save(currazn);
                }
            }
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    CurrencyRate curr = currencyRateRepository.findCurrencyValueBy1(elem.getAttribute("Code"));

                    if (curr == null) {

                        curr = new CurrencyRate();
                        curr.setCurrencyDate(new Date());
                        curr.setCurrencyCode(elem.getAttribute("Code"));
                        curr.setCurrencyName(elem.getElementsByTagName("Name").item(0).getTextContent());
                        curr.setCbarCurr(Double.parseDouble(elem.getElementsByTagName("Value").item(0).getTextContent()));
                        currencyRateRepository.save(curr);
                    } else {
                        curr.setCurrencyDate(new Date());
                        curr.setCurrencyCode(elem.getAttribute("Code"));
                        curr.setCurrencyName(elem.getElementsByTagName("Name").item(0).getTextContent());
                        curr.setCbarCurr(Double.parseDouble(elem.getElementsByTagName("Value").item(0).getTextContent()));
                    }

                }
            }
            return "Succes";
        }
    }