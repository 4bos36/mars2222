package studio.rashka;

import java.util.ArrayList;
import java.util.List;

public class InAppBillingResources {

    private static final String MONEY = "money";
    private static final String MONEY_2 = "money_2";
    private static final String MONEY_3 = "money_3";
    private static final String MONEY_4 = "money_4";
    private static final String MONEY_5 = "money_5";

    private static final String MINERAL = "mineral";
    private static final String MINERAL_2 = "mineral_2";
    private static final String MINERAL_3 = "mineral_3";
    private static final String MINERAL_4 = "mineral_4";
    private static final String MINERAL_5 = "mineral_5";

    private static final String SHIELDHPADD = "shieldhpadd";
    private static final String SHIELDHPADD_2 = "shieldhpadd_2";
    private static final String SHIELDHPADD_3 = "shieldhpadd_3";
    private static final String SHIELDHPADD_4 = "shieldhpadd_4";
    private static final String SHIELDHPADD_5 = "shieldhpadd_5";

    private static final String ENERGYADD = "energyadd";
    private static final String ENERGYADD_2 = "energyadd_2";
    private static final String ENERGYADD_3 = "energyadd_3";
    private static final String ENERGYADD_4 = "energyadd_4";
    private static final String ENERGYADD_5 = "energyadd_5";

    private static final String MICROWAVE = "microwave";
    private static final String MICROWAVE_2 = "microwave_2";
    private static final String MICROWAVE_3 = "microwave_3";
    private static final String MICROWAVE_4 = "microwave_4";
    private static final String MICROWAVE_5 = "microwave_5";

    private static List<String> listProduct;

    public static List<String> getListProduct() {
        listProduct = new ArrayList<>();

        listProduct.add(MONEY);
        listProduct.add(MONEY_2);
        listProduct.add(MONEY_3);
        listProduct.add(MONEY_4);
        listProduct.add(MONEY_5);

        listProduct.add(MINERAL);
        listProduct.add(MINERAL_2);
        listProduct.add(MINERAL_3);
        listProduct.add(MINERAL_4);
        listProduct.add(MINERAL_5);

        listProduct.add(SHIELDHPADD);
        listProduct.add(SHIELDHPADD_2);
        listProduct.add(SHIELDHPADD_3);
        listProduct.add(SHIELDHPADD_4);
        listProduct.add(SHIELDHPADD_5);

        listProduct.add(ENERGYADD);
        listProduct.add(ENERGYADD_2);
        listProduct.add(ENERGYADD_3);
        listProduct.add(ENERGYADD_4);
        listProduct.add(ENERGYADD_5);

        listProduct.add(MICROWAVE);
        listProduct.add(MICROWAVE_2);
        listProduct.add(MICROWAVE_3);
        listProduct.add(MICROWAVE_4);
        listProduct.add(MICROWAVE_5);

        return listProduct;
    }

    public static String getMONEY() {
        return MONEY;
    }

    public static String getMoney2() {
        return MONEY_2;
    }

    public static String getMoney3() {
        return MONEY_3;
    }

    public static String getMoney4() {
        return MONEY_4;
    }

    public static String getMoney5() {
        return MONEY_5;
    }

    public static String getMINERAL() {
        return MINERAL;
    }

    public static String getMineral2() {
        return MINERAL_2;
    }

    public static String getMineral3() {
        return MINERAL_3;
    }

    public static String getMineral4() {
        return MINERAL_4;
    }

    public static String getMineral5() {
        return MINERAL_5;
    }

    public static String getSHIELDHPADD() {
        return SHIELDHPADD;
    }

    public static String getShieldhpadd2() {
        return SHIELDHPADD_2;
    }

    public static String getShieldhpadd3() {
        return SHIELDHPADD_3;
    }

    public static String getShieldhpadd4() {
        return SHIELDHPADD_4;
    }

    public static String getShieldhpadd5() {
        return SHIELDHPADD_5;
    }

    public static String getENERGYADD() {
        return ENERGYADD;
    }

    public static String getEnergyadd2() {
        return ENERGYADD_2;
    }

    public static String getEnergyadd3() {
        return ENERGYADD_3;
    }

    public static String getEnergyadd4() {
        return ENERGYADD_4;
    }

    public static String getEnergyadd5() {
        return ENERGYADD_5;
    }

    public static String getMICROWAVE() {
        return MICROWAVE;
    }

    public static String getMicrowave2() {
        return MICROWAVE_2;
    }

    public static String getMicrowave3() {
        return MICROWAVE_3;
    }

    public static String getMicrowave4() {
        return MICROWAVE_4;
    }

    public static String getMicrowave5() {
        return MICROWAVE_5;
    }
}