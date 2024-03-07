package blind75;
public class VersionControl {
    private int firstBadVersion;

    // Fake implementation of isBadVersion provided by LeetCode
    public boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }

    // Setter method for setting the first bad version
    public void setFirstBadVersion(int version) {
        firstBadVersion = version;
    }
}