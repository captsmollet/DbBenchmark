package com.sitronics.it.dbbenchmark;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Singleton
 */
enum Stopwatch {
    INSTANCE;

    private List<Measurement> measurementList = new ArrayList<Measurement>();
    public void addMeasure(Measurement measurement) {
        measurementList.add(measurement);
    }

    public void clearMeasures() {
        measurementList.clear();
    }

    public List<Measurement> getMeasurementList() {
        return measurementList;
    }

    public List<Measurement> getMeasureListByBatch(int batchNum) {
        List<Measurement> list = new ArrayList<Measurement>();
        for (Measurement measurement : measurementList) {
            if (measurement.getBatchNum() == batchNum) list.add(measurement);
        }
        return list;
    }

    /*
     * Class holds single measurement
     */
    public static class Measurement {
        private long startTime, endTime;
        private int batchNum;
        private String measurementId;
        private Date elapsedTime;


        public int getBatchNum() {
            return batchNum;
        }

        public void setBatchNum(int batchNum) {
            this.batchNum = batchNum;
        }

        public String getMeasurementId() {
            return measurementId;
        }

        public void setMeasurementId(String measurementId) {
            this.measurementId = measurementId;
        }

        public Measurement(int batchNum, String measurementId) {
            this.batchNum = batchNum;
            this.measurementId = measurementId;
            elapsedTime = new Date();
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
            elapsedTime.setTime(endTime - startTime);
        }

        public String getElapsedTimeFormatted() {
            return DateFormat.getTimeInstance(DateFormat.MILLISECOND_FIELD).format(elapsedTime);
        }

        public long getElapsedTimeLong() {
            return endTime - startTime;
        }

    }
}