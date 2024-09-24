def date_after(date, after):
    date_year, date_month, date_day = [int(date) for date in date.split('.')]
    
    for _ in range(int(after)):
        if date_month == 12:
            date_year += 1
            date_month = 1
        else:
            date_month += 1
    
    return f'{date_year}.{date_month}.{date_day}'

def is_date1_before_date2(date1, date2):
    date1_year, date1_month, date1_day = [int(date) for date in date1.split('.')]
    date2_year, date2_month, date2_day = [int(date) for date in date2.split('.')]
    
    if date1_year == date2_year:
        if date1_month == date2_month:
            if date1_day <= date2_day:
                return True
        elif date1_month < date2_month:
            return True
    elif date1_year < date2_year:
        return True
    
    return False
    
def solution(today, terms, privacies):
    answer = []

    terms_dict = {term.split()[0] : term.split()[1] for term in terms}
    
    for i in range(len(privacies)):
        due, term = privacies[i].split()
        if is_date1_before_date2(date_after(due, terms_dict[term]), today):
            answer.append(i+1)
    
    return answer