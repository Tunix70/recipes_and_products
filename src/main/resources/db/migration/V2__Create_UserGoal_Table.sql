CREATE TABLE "azure".user_goal
(
    user_id      varchar(255),
    goal_weight  DOUBLE PRECISION not null,
    KCal_per_day DOUBLE PRECISION not null,
    PRIMARY KEY (user_id)
);