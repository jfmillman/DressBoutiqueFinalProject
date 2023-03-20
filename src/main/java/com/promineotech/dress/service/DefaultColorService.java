/**
 * 
 */
package com.promineotech.dress.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.dress.dao.ColorDao;
import com.promineotech.dress.entity.Color;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultColorService implements ColorService {

  @Autowired
  private ColorDao colorDao;
  
//Get (read colors)
@Transactional(readOnly=true)
@Override
  public List<Color> fetchListOfColors(Long colorPK) {
  log.info("The fetchListOfAllColors method was called with colorPK={}", colorPK);
  
  return colorDao.fetchListOfColors(colorPK);
  }

}
