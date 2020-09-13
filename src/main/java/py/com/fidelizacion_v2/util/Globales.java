/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.fidelizacion_v2.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

/**
 *
 * 
 */
public class Globales {
    public static final String  unitName = "py.com_fidelizacion_v2_war_1.0-SNAPSHOTPU";
    public static final Integer intervalo = 3600000;
    /**
     * 
     * @param d Date 
     * @return un valor para comprar fechas en la BD
     */
     public static Timestamp localToTimeStamp(Date d){
       String pattern = "yyyy-MM-dd";
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
       String dataFormat = simpleDateFormat.format(d);
       String [] data1= dataFormat.split("-");
       LocalDate date =LocalDate.of(            
               Integer.parseInt(data1[0]),
               Integer.parseInt(data1[1]),
               Integer.parseInt(data1[2]));
      return Timestamp.from(date.atStartOfDay().toInstant(ZoneOffset.UTC));
    }  
}
