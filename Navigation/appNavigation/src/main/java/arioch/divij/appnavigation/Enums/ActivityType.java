package arioch.divij.appnavigation.Enums;

/**
 * Created by divijdurve on 4/15/14.
 */
public enum ActivityType {
    ART("art"),
    BOOK_REPORT("bookreport"),
    MATH("math"),
    TEST("test"),
    TESTAA("testaa"),
    TEST124("testing 124"),
    TEST125("testing 124"),
    TEST_SCHEDULE("test schedule"),
    UNKNOWN("unknown");

    String value;

    ActivityType(String value)
    {
        this.value = value;
    }

    public static ActivityType extractEnumFromString(String value)
    {
        for(ActivityType activityType : ActivityType.values())
        {
            if(activityType.value.equalsIgnoreCase(value))
            {
                return activityType;
            }
        }
        return ActivityType.UNKNOWN;
    }
}
