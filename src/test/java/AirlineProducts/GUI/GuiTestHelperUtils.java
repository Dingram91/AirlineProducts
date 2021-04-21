/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts.GUI;

import java.awt.Color;

/**
 *
 * @author Dingr
 */
public class GuiTestHelperUtils {

    // Calculates the relative luminance (birghtness based on the human eye)
    static double calculateColorLuminance(Color c) {

        double normRed = c.getRed() / 255.0;
        double normGreen = c.getGreen() / 255.0;
        double normBlue = c.getBlue() / 255.0;

        double r = (normRed <= 0.03928) ? (normRed * 12.92) : (Math.pow((normRed + 0.055) / 1.055, 2.4));
        double g = (normGreen <= 0.03928) ? (normGreen * 12.92) : (Math.pow((normGreen + 0.055) / 1.055, 2.4));
        double b = (normBlue <= 0.03928) ? (normBlue * 12.92) : (Math.pow((normBlue + 0.055) / 1.055, 2.4));
//        return ((normRed * 0.299) + (normGreen * 0.587)
//                + (normBlue * 0.114));
        return (0.2126 * r) + (0.7152 * g) + (0.0722 * b);
    }

    static double calculateContrast(Color c1, Color c2) {
        double c1Luminance = calculateColorLuminance(c1) + 0.05;
        double c2Luminance = calculateColorLuminance(c2) + 0.05;
        System.out.println("c1 lum = " + c1Luminance);
        System.out.println("c2 lum = " + c2Luminance);
        double larger = Math.max(c1Luminance, c2Luminance);
        double smaller = Math.min(c1Luminance, c2Luminance);
        double ratio = larger / smaller;
        return ratio;

    }
}
