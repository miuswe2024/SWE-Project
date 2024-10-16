insert into station (city) values ('Denver');
insert into station (city) values ('Fairfield');
insert into station (city) values ('New York');
insert into station (city) values ('Iowa');

insert into car (registration_nr, construction_year, mileage, model, station_id)
values ('ABC123', 2023, 15000, 'Toyota', 1);

insert into car (registration_nr, construction_year, mileage, model, station_id)
values ('ABC234', 2023, 15000, 'Acura', 1);

insert into car (registration_nr, construction_year, mileage, model, station_id)
values ('ABC345', 2023, 15000, 'Mazda', 1);

insert into car (registration_nr, construction_year, mileage, model, station_id)
values ('ABC456', 2023, 15000, 'Audi', 1);

insert into car (registration_nr, construction_year, mileage, model, station_id)
values ('ABC567', 2024, 15000, 'BMW', 1);

insert into car (registration_nr, construction_year, mileage, model, station_id)
values ('ABC678', 2024, 15000, 'Mercedes', 2);

insert into car (registration_nr, construction_year, mileage, model, station_id)
values ('ABC789', 2024, 15000, 'Nissan', 2);

insert into car (registration_nr, construction_year, mileage, model, station_id)
values ('ABC8910', 2024, 15000, 'Infinity', 2);

insert into car (registration_nr, construction_year, mileage, model, station_id)
values ('ABC91011', 2024, 15000, 'Ford', 2);

insert into car (registration_nr, construction_year, mileage, model, station_id)
values ('ABC101112', 2024, 15000, 'Volvo', 2);

insert into car (registration_nr, construction_year, mileage, model, station_id)
values ('ABC111213', 2024, 15000, 'Hundai', 3);

insert into car (registration_nr, construction_year, mileage, model, station_id)
values ('ABC121314', 2024, 15000, 'Kia', 3);

insert into car (registration_nr, construction_year, mileage, model, station_id)
values ('ABC131415', 2024, 15000, 'Tesla', 3);

insert into car (registration_nr, construction_year, mileage, model, station_id)
values ('ABC141516', 2024, 15000, 'GeneralMotor', 4);

insert into car (registration_nr, construction_year, mileage, model, station_id)
values ('ABC151617', 2024, 15000, 'Honda', 4);

insert into car (registration_nr, construction_year, mileage, model, station_id)
values ('ABC161718', 2024, 15000, 'Mercury', 4);

insert into car (registration_nr, construction_year, mileage, model, station_id)
values ('ABC171819', 2024, 15000, 'Volkswagen', 4);

insert into customer (customer_number, first_name, last_name) values (123, 'Sujit', 'Chanda');
insert into customer (customer_number, first_name, last_name) values (234, 'Asif', 'Miazee');
insert into customer (customer_number, first_name, last_name) values (345, 'Shah', 'Jalal');
insert into customer (customer_number, first_name, last_name) values (456, 'Mainul', 'Islam');

insert into rental (rental_date, car_registration_nr, driver_customer_number,rental_station_id,
    return_date,return_station_id,km) values (CURRENT_DATE(), 'ABC123', 123, 1, CURRENT_DATE(),
    2, 500);

insert into rental (rental_date,car_registration_nr, driver_customer_number,rental_station_id,
    return_date, return_station_id, km) values (CURRENT_DATE(),  'ABC234', 234, 1, CURRENT_DATE(),
    2,  10000 );

insert into rental ( rental_date, car_registration_nr, driver_customer_number, rental_station_id,
    return_date, return_station_id, km) values (CURRENT_DATE(), 'ABC345', 345, 1, CURRENT_DATE(),
    2, 500);

insert into rental (rental_date, car_registration_nr, driver_customer_number,rental_station_id,
    return_date, return_station_id, km) values (CURRENT_DATE(), 'ABC456', 456, 1, CURRENT_DATE(),
    2, 500);

