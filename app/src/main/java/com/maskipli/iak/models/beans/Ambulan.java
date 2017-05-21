package com.maskipli.iak.models.beans;

import java.util.List;

/**
 * @author hidayat
 * @since 5/21/17.
 */

public class Ambulan {

    public VEHICLE VEHICLE;

    public static class DATA {
        public int NO;
        public String GPSSTATE;
        public int GPS;
        public int TIME;
        public String USERNAME;
        public String TIME_FORMAT;
        public String LICENSE;
        public String TERMINAL;
        public String OWNERTELP;
        public String OWNERNAME;
        public String TYPE;
        public String LONGITUDE;
        public String LATITUDE;
        public String ADDRESS;
        public int SPEED;
        public int DIRECTION;
        public int MILEAGE;
        public int ALARMSTATE;
        public int CARSTATE;
        public String ICONID;
        public String GSM;
        public String STATUS;
        public String STATUS_ENGINE;
        public String EXP_DATE;
        public String STATUS_EXP;
        public String VEHICLE_STATE;
        public String VEHICLE_TYPE;
    }

    public static class VEHICLE {
        public String RESULT;
        public String COMMAND;
        public int COUNT;
        public List<DATA> DATA;
        public String DATA_USER;
    }
}
