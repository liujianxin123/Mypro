package shejimoshi.shipeiqimoshi;

public class ASensitiveWordsFilterAdaptor implements ISensitiveWordsFilter{
    private ASensitiveWordsFilter aFilter;
    public String filter(String text) {
        String maskedText = aFilter.filterSexyWords(text);
        maskedText = aFilter.filterPoliticalWords(maskedText);
        return maskedText;
    }
}
