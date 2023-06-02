package com.example.testTask;

import com.example.testTask.currencyservice.interfaces.CurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootApplication
public class TestTaskApplication implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(TestTaskApplication.class);
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	CurrencyService currencyService;

	public static void main(String[] args) {
		SpringApplication.run(TestTaskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Creating tables");

		jdbcTemplate.execute("DROP TABLE IF EXISTS public.query_history");
		jdbcTemplate.execute("DROP TABLE IF EXISTS public.currency_history");
		jdbcTemplate.execute("DROP TABLE IF EXISTS public.currency_codes");
		jdbcTemplate.execute("DROP TABLE IF EXISTS public.users");

		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS public.currency_codes\n" +
				"(\n" +
				"    id SERIAL,\n" +
				"    char_code text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    name text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    CONSTRAINT currency_codes_pkey PRIMARY KEY (id)\n" +
				")");
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS public.currency_history\n" +
				"(\n" +
				"    id SERIAL,\n" +
				"    date text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr1 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr2 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr3 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr4 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr5 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr6 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr7 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr8 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr9 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr10 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr11 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr12 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr13 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr14 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr15 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr16 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr17 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr18 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr19 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr20 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr21 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr22 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr23 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr24 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr25 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr26 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr27 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr28 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr29 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr30 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr31 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr32 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr33 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr34 text COLLATE pg_catalog.\"default\" NOT NULL DEFAULT 1,\n" +
				"    curr0 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    CONSTRAINT currency_history_pkey PRIMARY KEY (id)\n" +
				")");
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS public.query_history\n" +
				"(\n" +
				"    id SERIAL,\n" +
				"    curr1 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    curr2 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    value1 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    value2 text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    date text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    user_id integer NOT NULL,\n" +
				"    CONSTRAINT query_history_pkey PRIMARY KEY (id)\n" +
				")");
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS public.users\n" +
				"(\n" +
				"    id SERIAL,\n" +
				"    login text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    password character(32) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    CONSTRAINT users_pkey PRIMARY KEY (id)\n" +
				")");

		currencyService.load();
	}
}
