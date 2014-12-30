
package com.evolution.model;

import java.io.Serializable;

/**
 *
 * @author Anthony
 */
public interface CONSTANTS extends Serializable{
    //**************************************************************************
    // VARIABLES DES ANIMAUX
    //**************************************************************************
    
    public static final     int         WOLF_HUNGER         = 10;
    public static final     int         WOLF_LIFETIME       = 60;
    public static final     int         WOLF_REPRODUCTIVITY = 5;
    public static final     int         SHEEP_HUNGER        = 5;
    public static final     int         SHEEP_LIFETIME      = 50;
    public static final     int         SHEEP_REPRODUCTIVITY = 5;
    
    //**************************************************************************
    // VARIABLES GRAPHIQUES
    //**************************************************************************
    public static final     int         FRAME_SIZE_L        = 960;
    public static final     int         FRAME_SIZE_H        = 860;
    
    public static final     int         JDIALOG_SIZE_L      = 550;
    public static final     int         JDIALOG_SIZE_H      = 450;
    
    public static final     String      FRAME_TITLE         = "EVOLUTION";
    public static final     String      JDIALOG_TITLE       = "WORLD BUILDER";
    
    public static final     int         FONT_COUNTERS_SIZE  = 20;
    public static final     int         FONT_COUNTERS_NUMBERS = 30;
    
    public static final     String      PATH_IMG            = "src/com/evolution/view/img/";
    
    //**************************************************************************
    // PARAMETRES DE DEPART OPTIMAUX
    //**************************************************************************
    
    public static final     int         NB_LINE_OPTIMAL             = 20;
    public static final     int         NB_COLUMN_OPTIMAL           = 20;
    public static final     int         NB_WOLFS_OPTIMAL            = 10;
    public static final     int         NB_SHEEPS_OPTIMAL           = 30;
    public static final     int         NB_GRASS_OPTIMAL            = 400;
    public static final     int         NB_MINERALS_OPTIMAL         = 0;
}
