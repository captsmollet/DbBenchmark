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

    private List<Measure> measureList = new ArrayList<Measure>();
    public void addMeasure(Measure measure) {
        measureList.add(measure);
    }

    public void clearMeasures() {
        measureList.clear();
    }

    public List<Measure> getMeasureList() {
        return measureList;
    }

    public static class Measure {
        private long startTime, endTime;
        private int batchNum;
        private String measureId;
        private Date elapsedTime;


        public int getBatchNum() {
            return batchNum;
        }

        public void setBatchNum(int batchNum) {
            this.batchNum = batchNum;
        }

        public String getMeasureId() {
            return measureId;
        }

        public void setMeasureId(String measureId) {
            this.measureId = measureId;
        }

        public Measure(int batchNum, String measureId) {
            this.batchNum = batchNum;
            this.measureId = measureId;
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