package shejimoshi.shipeiqimoshi;

import java.util.ArrayList;
import java.util.List;

public class RiskManagement {
    private List<ISensitiveWordsFilter> filters = new ArrayList<>();
    public void addSensitiveWordsFilter(ISensitiveWordsFilter filter) {
        filters.add(filter);
    }
    public String filterSensitiveWords(String text) {
        String maskedText = text;
        for (ISensitiveWordsFilter filter : filters) {
            maskedText = filter.filter(maskedText);
        }
        return maskedText;
    }

    public static void main(String[] args) {
        RiskManagement riskManagement = new RiskManagement();


        riskManagement.addSensitiveWordsFilter(new ASensitiveWordsFilterAdaptor());

    }
}
