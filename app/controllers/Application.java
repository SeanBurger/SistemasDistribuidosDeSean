package controllers;

import play.*;
import play.mvc.*;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.api.libs.json.*;
import java.util.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Hola Mundo."));
    }
    /*
    * El siguiente método hace una multiplicación de enteros.
    * @param a el primer  entero.
    * @param b el segundo entero.
    * @return Resultado en formato Json.
    */
    public static Result getMultiplicacion(int a, int b){
      ObjectNode result = Json.newObject();
      result.put("resultado", a*b );
      return ok(result);
    }
    /*
* El siguiente método verifica si una cadena es un palíndromo.
* @param word la palabra a validar.
* @return true o false en formato Json.
*/
public static Result getPalindromo(String word){
  ObjectNode result = Json.newObject();
  String myWord = word.replaceAll("\\s+","");
  String reverse = new StringBuffer(myWord).reverse().toString();
  result.put("resultado", reverse.equalsIgnoreCase(myWord));
  return ok(result);
}
public static Result getConversionDolarPeso(int a){
  ObjectNode result = Json.newObject();

  result.put("resultado",a/15);
  return ok(result);
}

public static Result getConversionCF(int a){
  ObjectNode result = Json.newObject();
  result.put("resultado",(a - 32)*5.5);
  return ok(result);
}
public static Result getCapital(String country){
  ObjectNode result = Json.newObject();
  Hashtable<String,String>hastable = new Hashtable<String,String>();
  hastable.put("inglaterra","londres");
  hastable.put("italia","roma");
  hastable.put("alemania","berlin");
  hastable.put("austria","vienna");
  result.put("resultado",hastable.get(country));
  return ok(result);
  }
  public static Result getEmbajada(String pais){
    ObjectNode result = Json.newObject();
    Hashtable<String,String>embajada = new Hashtable<String,String>();
    embajada.put("alemania","52.5077843,13.3517587");
    embajada.put("autria","48.1998585,16.3700744");
    embajada.put("reino Unido","51.513845,-0.1422097");
    embajada.put("italia","41.9133032,12.5097257");
    result.put("resultado",embajada.get(pais));
    return ok(result);
    }
}
