-- public."user" definition

-- Drop table

-- DROP TABLE public."user";

CREATE TABLE public."user" (
	id bigserial NOT NULL, -- Идентификатор
	username varchar(50) NULL, -- Имя пользователя
	"password" varchar(72) NULL, -- Пароль (BCrypt)
	roles varchar NULL, -- Роли
	CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Column comments

COMMENT ON COLUMN public."user".id IS 'Идентификатор';
COMMENT ON COLUMN public."user".username IS 'Имя пользователя';
COMMENT ON COLUMN public."user"."password" IS 'Пароль (BCrypt)';
COMMENT ON COLUMN public."user".roles IS 'Роли';

INSERT INTO public."user" (username,"password",roles) VALUES
	 ('dendil','$2a$10$779ghU3g2Uvak7ija9gQXe78.DZ1hnyN4Mnv0BEvubgZpUZzPJfIy','user');