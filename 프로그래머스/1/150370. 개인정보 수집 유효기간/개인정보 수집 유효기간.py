def add_months_to_date(start_date, months_to_add):
    year, month, day = [int(part) for part in start_date.split('.')]
    
    for _ in range(int(months_to_add)):
        if month == 12:
            year += 1
            month = 1
        else:
            month += 1
    
    return f'{year}.{month:02d}.{day:02d}'

def is_date_before_or_equal(date1, date2):
    formatted_date1 = date1.replace('.', '')
    formatted_date2 = date2.replace('.', '')
    
    return formatted_date1 <= formatted_date2

def solution(today, terms, privacies):
    result = []

    # {약관 : 유효기간} 딕셔너리 생성
    terms_duration_map = {term.split()[0]: term.split()[1] for term in terms}
    
    for idx, privacy in enumerate(privacies):
        privacy_date, privacy_term = privacy.split()
        expiration_date = add_months_to_date(privacy_date, terms_duration_map[privacy_term])
        
        if is_date_before_or_equal(expiration_date, today):
            result.append(idx + 1)
    
    return result
