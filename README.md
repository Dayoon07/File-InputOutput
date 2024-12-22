# DB 구조

## 1. `u_video` 테이블

| **필드**       | **타입**                  | **제약조건**            |
|----------------|---------------------------|-------------------------|
| `video_id`     | `NUMBER`                  | `GENERATED`, `INCREMENT`, `PK` |
| `title`        | `VARCHAR2(255 CHAR)`       | `NOT NULL`              |
| `description`  | `VARCHAR2(500 CHAR)`       | -                       |
| `filepath`     | `VARCHAR2(500 CHAR)`       | `NOT NULL`              |
| `created`      | `VARCHAR2(50 CHAR)`        | `NOT NULL`              |
| `views`        | `NUMBER`                  | `DEFAULT 0`            |

---

## 2. `u_img` 테이블

| **필드**       | **타입**                  | **제약조건**            |
|----------------|---------------------------|-------------------------|
| `img_id`       | `NUMBER`                  | `GENERATED`, `INCREMENT`, `PK` |
| `imgname`      | `VARCHAR2(255 CHAR)`       | `NOT NULL`              |
| `filepath`     | `CLOB`                     | `NOT NULL`              |
| `datetime`     | `VARCHAR2(50 CHAR)`        | `NOT NULL`              |
| `views`        | `NUMBER`                  | `DEFAULT 0`            |
