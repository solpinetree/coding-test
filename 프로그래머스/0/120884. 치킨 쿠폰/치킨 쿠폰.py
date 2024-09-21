# 한마리당 쿠폰 한장, 쿠폰 열 장 모으면 치킨 한 마리 서비스
# 1081마리 시켜먹음 -> 쿠폰 1081개
# 쿠폰 1081개 -> 1081//10 -> 108마리 + 쿠폰 108개 + 남은 쿠폰 1개
# 쿠폰 109개 -> 109//10 = 10마리 + 쿠폰 10개 + 남은 쿠폰 9개
# 쿠폰 19개 -> 19//10 = 1마리 + 쿠폰 1개 + 남은 쿠폰 9개
# 쿠폰 10개 -> 10//10 = 1마리 + 쿠폰 1개
# 총 : 108+10+1+1 = 120마리
def solution(chicken):
    answer = 0
    
    coupon = chicken
    while coupon >= 10:
        coupon_chicken = coupon//10 
        answer = answer + coupon_chicken
        coupon = coupon%10 + coupon_chicken
    
    return answer