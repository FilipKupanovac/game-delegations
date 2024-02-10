-- basic test data to inject into database for manual application testing
insert into venue (id, uuid, name, address, latitude, longitude)
values (1, '0000aaaa-bbbb-cccc-dddd-eeeeffff0001', 'SD Jug II', 'Ul. kralja Petra Svačića 67, 31000, Osijek', '45.542779420655805', '18.70993989916577'),
       (2, '0000aaaa-bbbb-cccc-dddd-eeeeffff0002', 'SD Vijuš', '35000, Slavonski Brod', '45.149038219716005', '18.024494302699985'),
       (3, '0000aaaa-bbbb-cccc-dddd-eeeeffff0003', 'Nastavno športska dvorana Belišće', '31551, Belišće', '45.68320103001361', '18.405175127117655');

insert into competition (id, uuid, name, season)
values (1, '1111aaaa-bbbb-cccc-dddd-eeeeffff0001', '2. Muška liga - istok', '2023./2024.'),
       (2, '1111aaaa-bbbb-cccc-dddd-eeeeffff0002', 'U-19 Juniori regija istok', '2023./2024.'),
       (3, '1111aaaa-bbbb-cccc-dddd-eeeeffff0003', 'Kadeti kup regija - istok', '2023./2024.');

insert into sport_club (id, uuid, name, city)
values (1, '2222aaaa-bbbb-cccc-dddd-eeeeffff0001', 'KK Belišće', 'Belišće'),
       (2, '2222aaaa-bbbb-cccc-dddd-eeeeffff0002', 'KK Vladislavci', 'Vladislavci'),
       (3, '2222aaaa-bbbb-cccc-dddd-eeeeffff0003', 'KA Osijek', 'Osijek'),
       (4, '2222aaaa-bbbb-cccc-dddd-eeeeffff0004', 'KK Brod', 'Slavonski Brod'),
       (5, '2222aaaa-bbbb-cccc-dddd-eeeeffff0005', 'KK Marsonia', 'Slavonski Brod');

insert into table_official (id, uuid, first_name, last_name)
values (1, '3333aaaa-bbbb-cccc-dddd-eeeeffff0001', 'a', 'a'),
       (2, '3333aaaa-bbbb-cccc-dddd-eeeeffff0002', 'b', 'b'),
       (3, '3333aaaa-bbbb-cccc-dddd-eeeeffff0003', 'c', 'c'),
       (4, '3333aaaa-bbbb-cccc-dddd-eeeeffff0004', 'd', 'd'),
       (5, '3333aaaa-bbbb-cccc-dddd-eeeeffff0005', 'e', 'e'),
       (6, '3333aaaa-bbbb-cccc-dddd-eeeeffff0006', 'f', 'f'),
       (7, '3333aaaa-bbbb-cccc-dddd-eeeeffff0007', 'g', 'g'),
       (8, '3333aaaa-bbbb-cccc-dddd-eeeeffff0008', 'h', 'h'),
       (9, '3333aaaa-bbbb-cccc-dddd-eeeeffff0009', 'i', 'i'),
       (10, '3333aaaa-bbbb-cccc-dddd-eeeeffff0010', 'j', 'j'),
       (11, '3333aaaa-bbbb-cccc-dddd-eeeeffff0011', 'k', 'k'),
       (12, '3333aaaa-bbbb-cccc-dddd-eeeeffff0012', 'l', 'l'),
       (13, '3333aaaa-bbbb-cccc-dddd-eeeeffff0013', 'm', 'm'),
       (14, '3333aaaa-bbbb-cccc-dddd-eeeeffff0014', 'n', 'n'),
       (15, '3333aaaa-bbbb-cccc-dddd-eeeeffff0015', 'o', 'o'),
       (16, '3333aaaa-bbbb-cccc-dddd-eeeeffff0016', 'p', 'p'),
       (17, '3333aaaa-bbbb-cccc-dddd-eeeeffff0017', 'q', 'q'),
       (18, '3333aaaa-bbbb-cccc-dddd-eeeeffff0018', 'r', 'r'),
       (19, '3333aaaa-bbbb-cccc-dddd-eeeeffff0019', 's', 's'),
       (20, '3333aaaa-bbbb-cccc-dddd-eeeeffff0020', 't', 't');

-- insert game test data
INSERT INTO game (id, uuid, competition_id, start_time, game_number, venue_id, host_id, guest_id, scorer_id, timer_id, shot_clock_id, statistician_id, statistician_assistant_id)
VALUES (1, '4444aaaa-bbbb-cccc-dddd-eeeeffff0001', 1, '2024-02-09 12:00:00', 1, 1, 1, 5, 11, 12, 13, 14, 15);