package htmlanalyzer.model;

import lombok.Data;

@Data
public class HtmlAnalysis {
    private String htmlVersion;

    private String title;

    /**
     * Stores the number of headings grouped by heading level.
     * Each element in the array represents the number of headings for heading level (array-index) + 1.
     * For example, the first element in the array with index = 0 represents the number of H1 headings in the page.
     */
    private int[] numHeadingsByLevel = new int[6];

    private int numInternalLinks;

    private int numExternalLinks;

    private boolean containsLoginForm;

    public void increaseHeadingCount(int headingLevel) {
        int index = headingLevel - 1;
        int oldCount = numHeadingsByLevel[index];
        numHeadingsByLevel[index] = oldCount + 1;
//        numHeadingsByLevel[index]++; FIXME: Would it work?
    }

    public void increaseInternalLinkCount() {
        numInternalLinks++;
    }

    public void increaseExternalLinkCount() {
        numExternalLinks++;
    }
}
