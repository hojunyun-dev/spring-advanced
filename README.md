📝 README – Spring 심화과제 레벨1~3 
🌟 과제 개요
목표: 실무형 Spring 백엔드 개발 역량 강화 (리팩토링, N+1, 테스트코드 등)

✅ 요구사항
LV1️⃣ 코드개선
Early Return

조건에 맞지 않은 경우 즉시 리턴하여 불필요한 로직을 실행 방지하고 성능 향상

AuthService 클래스에서 signup 메서드 리팩토링

리팩토링 퀴즈

불필요한 if-else 피하기

복잡한 if-else 구조는 코드의 가독성을 떨어트리고 유지보수를 어렵게 만듬

WeatherClient 클래스에서 getTodayWeather() 메서드 리팩토링

코드 개선 퀴즈

UserService 클래스에서 changePassword() 메서드 리팩토링

Validation → 요청 DTO에서 처리 할 수 있도록 수정

LV2️⃣ N+1 문제
N+1 문제

TodoRepository에서 JPQL fetch join을 @EntityGraph 기반 구현으로 수정

TodoController TodoService 통해 Todo 관련 데이터 처리
LV3️⃣ 테스트 코드 연습
예상대로 성공하는지

test 패키지 안에서 PassEncoderTest 클래스에 matches_메서드가_정상적으로_동작한다()가 성공하도록 수정
예상대로 예외처리를 하는지

test 패키지 안에서 ManagerServiceTest 클래스에 manager_목록_조회_시_Todo가_없다면_NPE_에러를_던진다()가 성공하도록 테스트코드와 메서드명 수정

test 패키지 안에서 CommentServiceTest 클래스에 comment_등록_중_할일을_찾지_못해_에러가_발생한다()가 테스트코드 성공하도록 수정

test 패키지 안에서 ManagerServiceTest 클래스에 todo의_user가_null인_경우_예외가_발생한다()가 서비스코드 성공하도록 수정

🚀 레벨 1 – 코드 개선/리팩토링
✔️ Early Return 적용
불필요한 연산(암호화 등)을 조건문 위로 이동하여 성능 향상 및 가독성 개선

커밋 예시:

sql
복사
편집
레벨 1-1: Early Return 패턴 적용 (이미 존재하는 이메일 체크)
✔️ if-else 구조 개선
불필요한 else 블록 제거로 코드의 중첩/복잡도 낮춤

실전에서 조건/예외 상황부터 먼저 처리!

✔️ Validation 로직의 DTO 이전
비밀번호 등 복잡한 유효성 검증을 DTO 어노테이션(@Pattern, @Size 등)으로 이전

코드 분리, 재사용성, 자동화된 검증까지 달성

⚡️ 레벨 2 – JPA N+1 문제 해결
✔️ fetch join → @EntityGraph 리팩토링
기존 JPQL fetch join 코드를 @EntityGraph로 대체

간결한 코드 + N+1 문제 완벽 해결 + 유지보수성↑

트러블슈팅:

기존에 fetch join 쿼리(@Query)를 쓰던 곳에서
→ @EntityGraph(attributePaths = "user")로 변경
→ 서비스/컨트롤러의 findByIdWithUser → findById 네이밍도 함께 수정 필요

🧪 레벨 3 – 테스트코드/예외처리 자동화
✔️ 테스트 코드 파라미터 순서 실수
matches(원본, 암호화된 값) 순서가 아니라
반대로 써서 테스트가 실패했음
→ 파라미터 순서 주의

✔️ 예외 메시지/타입 일치 주의
테스트의 기대 메시지와 실제 코드의 예외 메시지가 1글자라도 다르면 실패

예외 타입(InvalidRequestException 등)도 테스트/구현 코드 양쪽 모두 일치시켜야 성공

✔️ NPE vs 명확한 예외처리 트러블슈팅
실수:

user가 null인 경우 .getId() 호출에서 NPE 발생

(예: null 체크 코드를 id 비교(if문) 밑에 둠)

해결:

null 체크는 항상 객체 사용(메서드 호출) 전에
“가장 먼저” 해야 원하는 예외로 안전하게 처리할 수 있음

💡 트러블슈팅
null 체크 위치를 id 접근 전에 해야 커스텀 예외로 명확히 처리할 수 있다.
예외 메시지/타입/순서가 정확히 맞아야 테스트코드가 통과
fetch join에서 @EntityGraph로 바꿀 땐, 네이밍/사용법도 함께 맞춰야 에러 X
자세한 트러블 슈팅 관련 내용은 https://hoojun99.tistory.com/

✅ 실전에서 배운 점
리팩토링 시 “불필요한 연산/조건”부터 early return으로 빼는 습관
유효성 검사는 DTO에서
테스트코드는 내가 실수하는 부분을 자동으로 잡아주는 최고의 개발자 도구
예외 처리, null 체크, 예외 메시지 등은 항상 꼼꼼하게 맞추기


