package com.bitc.ajax.service;

import com.bitc.ajax.dto.BoxOfficeDto;
import com.bitc.ajax.dto.Covid19InfoDto;
import com.bitc.ajax.dto.Covid19InfoItemDto;
import com.bitc.ajax.dto.DailyBoxOfficeDto;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class KobisServiceImpl implements KobisService {
    @Override
    public List<DailyBoxOfficeDto> getItemListUrl(String serviceUrl, String type) throws Exception {
        List<DailyBoxOfficeDto> itemList = null;

        URL url = null;
        HttpURLConnection urlConn = null;

        try {
            url = new URL(serviceUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");

            if (type.equals("xml")) {
                JAXBContext jc = JAXBContext.newInstance(BoxOfficeDto.class);
                Unmarshaller um = jc.createUnmarshaller();

                BoxOfficeDto boxOfficeResult = (BoxOfficeDto) um.unmarshal(url);
                itemList = boxOfficeResult.getDailyBoxOfficeList().getItemList();
            }
            else {
                itemList = getItemListJson(serviceUrl);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (urlConn != null) {
                urlConn.disconnect();
            }
        }

        return itemList;
    }
}


