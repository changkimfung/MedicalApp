package Medical.framework.Filter;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成Token
 * @author zhengjianfeng
 * @date 2019/3/21 8:52
 * @param
 * @return
 */
@Component
public class TokenUtils {
    SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;
    private static final int a= Calendar.DATE;
    private static final String secret="zhengjianfeng";
    Map<String,Object> claims=new HashMap<String, Object>();

/**
 * 生成Token
 * @author zhengjianfeng
 * @date 2019/3/21 9:07
 * @param username
 * @param password
 * @return java.lang.String
 */
public String createToken(String username,String password){
   //发行时间
    Calendar calendar=Calendar.getInstance();

    Date nowTime=new Date(calendar.getTime().getTime());
    long nowMillis =nowTime.getTime();

    //截止时间

    calendar.add(a, 7);
    Date deadline= calendar.getTime();
    //载荷
    claims.put("username",username);
    claims.put("password", password);
    claims.put("deadline", deadline.getTime());


    String token= Jwts.builder().setClaims(claims)
                                .setIssuedAt(nowTime)
                                .setExpiration(deadline)
                                .setId(String.valueOf(nowMillis))
                                .signWith(signatureAlgorithm, secret)
                                .compact();

    return token;


}

/**
 * 解析Token
 * @author zhengjianfeng
 * @date 2019/3/21 9:07
 * @param Token
 * @return
 */
  public Map<String,Object>getClaims(String Token){

      Jws<Claims> jws  =Jwts.parser().setSigningKey(secret).parseClaimsJws(Token);
      String siganture=jws.getSignature();
      Map<String,Object> header=jws.getHeader();
        String username=jws.getBody().get("username").toString();
        String password=jws.getBody().get("password").toString();
      long deadline=Long.valueOf(jws.getBody().get("deadline").toString());





        Map<String,Object> value=new HashMap<>();
        value.put("username", username);
        value.put("password", password);
         value.put("deadline", String.valueOf(deadline));
        return value;
  }
}
