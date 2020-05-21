package shejimoshi.guanchazhemoshi;

public class RegPromotionObserver implements RegObserver {
    @Override
    public void handleRegSuccess(long userId) {
        System.out.println("进来了"+userId);
//        private PromotionService promotionService; // 依赖注入
//
//        @Override
//        public void handleRegSuccess(long userId) { promotionService.issueNewUserExperienceCash(userId); }
    }
}
