package com.example.jussi.tyokohtainenriskinarviointi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jussi on 1/29/17.
 */

public class PassWordTest {






    public void main (String args[]){




        Pattern p = Pattern.compile("\\w");
        Matcher m = p.matcher("jussi");

        m.find();

        System.out.print(m.matches());


    }




}
