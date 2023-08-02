# Rule Base Demo 

## 프로젝트 목적
- Rule Base 에 대한 예제를 따라하고 감을 잡는다.

## Rule Base Engin 이란?

## Rule Base Engin 대표주자는?

## 기초데이터
```sql
INSERT INTO rules 
 (rule_namespace , rule_id, condition_text, 
 action_text, priority, description_text) 
VALUES (
 'LOAN',
 '1',
 'input.monthlySalary >= 50000 && input.creditScore >= 800 && input.requestedLoanAmount < 4000000 && $(bank.target_done) == false', 
 'output.setApprovalStatus(true);output.setSanctionedPercentage(90);output.setProcessingFees(8000);', 
 '1', 
 'A person is eligible for Home loan?'
);

INSERT INTO rules 
 (rule_namespace , rule_id, condition_text, 
 action_text, priority, description_text) 
VALUES (
 'LOAN',
 '2',
 'input.monthlySalary >= 35000 && input.monthlySalary <= 50000 && input.creditScore <= 500 && input.requestedLoanAmount < 2000000 && $(bank.target_done) == false',
'output.setApprovalStatus(true);output.setSanctionedPercentage(60);output.setProcessingFees(2000);', 
 '2', 
 'A person is eligible for Home loan?'
);

commit;

```


## 테스트 방법
- 전체 룰 확인 : http://localhost:8080/get-all-rules
- 요청에 대한 룰 결과 확인  http://localhost:8080/loan
- 요청
```json
{
 "creditScore": 900,
 "firstName": "Mark",
 "lastName": "K",
 "age": "25",
 "accountNumber": 123456789,
 "bank": "ABC BANK",
 "requestedLoanAmount": 3500000.0,
 "monthlySalary": 70000.0
}
```

- 응답
```json
{
    "accountNumber": null,
    "approvalStatus": true,
    "interestRate": null,
    "sanctionedPercentage": 90.0,
    "processingFees": 8000.0
}
``` 


## 활용방법

## 결론

## 참고자료
- https://medium.com/@er.rameshkatiyar/implement-your-own-rule-engine-java8-springboot-mvel-5928474e1ba5
- https://github.com/eugenp/tutorials/tree/master/drools
- https://ryuuun.tistory.com/13
- https://github.com/Rameshkatiyar/rules-engine/blob