/**
 * 
 */
package com.promineotech.dress.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.dress.dao.ColorOptionsDao;
import com.promineotech.dress.entity.Color;
import com.promineotech.dress.entity.Color_Options;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultColorOptionsService implements ColorOptionsService {
  
  @Autowired
  private ColorOptionsDao colorOptionsDao;

//Get (read colors)
// Applied a transactional annotation for read only bc nothing will change
@Transactional(readOnly=true)
@Override
  public List<Color_Options> fetchColors(Long dressFk) {
    log.info("The fetchColors method was called with dressFk={}", dressFk);
    
    return colorOptionsDao.fetchColors(dressFk);
  }

}
