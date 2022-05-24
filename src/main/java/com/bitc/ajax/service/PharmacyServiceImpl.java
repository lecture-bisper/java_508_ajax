package com.bitc.ajax.service;

import com.bitc.ajax.dto.*;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.util.List;

@Service
public class PharmacyServiceImpl implements PharmacyService {
  @Override
  public List<PharmacyItemDto> getItemList() throws Exception {

//    jaxb : 자바에서 xml 데이터를 자바 object 타입으로 파싱하도록 도와주는 라이브러리
//    Marshal(마샬) : 자바 클래스를 xml 데이터로 변환
//    UnMarshal(언마샬) : xml 데이터를 자바 클래스로 변환

//    JAXB 라이브러리 로드
//    JAXB 라이브러리를 통해서 xml 데이터와 연동할 자바 클래스를 설정
    JAXBContext jc = JAXBContext.newInstance(PharmacyFullDataDto.class);

//    언마샬 사용
    Unmarshaller um = jc.createUnmarshaller();

//    실제 xml 데이터 파일을 로드하여 jaxb 라이브러리로 언마샬 실행
//    ummarshal() 메서드의 반환값이 Object 이기 때문에 PharmacyFullDataDto 클래스 타입으로 강제 형변환
//    xml의 모든 데이터를 PharmacyFullDataDto 클래스 타입의 객체에 저장
    PharmacyFullDataDto fullData = (PharmacyFullDataDto) um.unmarshal(new File("C://java508//pharmacyFullData.xml"));
    PharmacyHeaderDto headerData = fullData.getHeader();
    PharmacyBodyDto bodyData = fullData.getBody();
    PharmacyItemsDto itemsData = bodyData.getItems();

//    실제 우리가 원하는 데이터만 추출
    List<PharmacyItemDto> itemList = itemsData.getItemList();

    return itemList;
  }
}
