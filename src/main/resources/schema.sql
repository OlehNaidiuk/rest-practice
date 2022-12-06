CREATE TABLE IF NOT EXISTS teacher
(
    teacher_id BIGINT NOT NULL AUTO_INCREMENT,
    teacher_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (teacher_id)
);

CREATE TABLE IF NOT EXISTS grp
(
    group_id BIGINT NOT NULL AUTO_INCREMENT,
    group_name VARCHAR(255) NOT NULL,
    teacher_id BIGINT NULL,
    PRIMARY KEY (group_id),
    FOREIGN KEY (teacher_id)
        REFERENCES teacher (teacher_id)
);