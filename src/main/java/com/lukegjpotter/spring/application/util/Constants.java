package com.lukegjpotter.spring.application.util;

import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final String FILE_FORMAT = "UTF-8";
    public static final String DATE_FORMAT_MMMM_DD_YYYY = "MMMM dd, yyyy";
    public static final String DATE_FORMAT_MMM_DD_YYYY = "MMM dd, yyyy";
    public static final String DATE_FORMAT_DD_MMM_YYYY = "dd MMM yyyy";
    public static final String DATE_FORMAT_DD_MM_YYYY = "dd/MM/yyyy";
    public static final String DATE_FORMAT_DD_MMM_YY = "dd-MMM-yy";
    public static final List<String> YOUTH_RACE_TYPES = Arrays.asList("u16", "u14", "u12", "u10");
    public static final List<String> VETS_RACE_TYPES = Arrays.asList("m40", "m50", "m60");
    public static final List<String> PARACYCLING_RACE_TYPES = Arrays.asList("tandem_b1_b3", "handcycling_h1_h5", "solobikes_c1_c5", "tricycle_t1_t3");
}
