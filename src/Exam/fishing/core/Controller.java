package Exam.fishing.core;

public interface Controller {

    String addSite(String siteType, String siteName, int quota);

    String addFisherman(String siteName, String fishermanType, String fishermanName);

    String goFishing(String siteName);

    String getStatistics();
}
