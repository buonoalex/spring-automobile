
-- INSERT AUTOTYPE
INSERT INTO type (name, descrizione) VALUES ('Coupé', 'Auto a due porte e tetto fisso. Il volume della parte posteriore è ridotto a favore di una linea più sportiva (meno spazio per passeggeri posteriori e bagagli).');
INSERT INTO type (name, descrizione) VALUES ('Suv', 'Auto progettata per offrire una combinazione di caratteristiche di un veicolo fuoristrada e di una berlina tradizionale');
INSERT INTO type (name, descrizione) VALUES ('Van', 'Auto progettata principalmente per il trasporto di merci o passeggeri.');
INSERT INTO type (name, descrizione) VALUES ('Sportive', 'Auto progettata offrire prestazioni sopra la media, con dei design areodinamici e leggeri.');

-- INSERT AUTO
INSERT INTO automobili (name, description, foto, price, auto_type_id,logo,marca, cambio, anno, carburante, kmL, cavalli) VALUES ('Audi A1', 'Auto sportiva e tecnologica, con interni curati e tanto spazio a bordo. Il design è accattivante e grintoso, con un profilo slanciato e un assetto ribassato per una perfetta tenuta di strada.', 'https://th.bing.com/th/id/OIP.iU6Fiq_s0sAg8Kf-iWTWAQHaEK?rs=1&pid=ImgDetMain', 25800, 1,'https://seeklogo.com/images/A/Audi-logo-ED84DFE2E3-seeklogo.com.png','Audi', 'Manuale', 2020, 'Diesel', 17, 130);
INSERT INTO automobili (name, description, foto, price, auto_type_id,logo,marca, cambio, anno, carburante, kmL, cavalli) VALUES ('T-Roc', 'Il Volkswagen T-Roc è un SUV compatto prodotto dalla casa automobilistica tedesca Volkswagen. Lanciato nel 2017, il T-Roc si distingue per il suo design moderno e sportivo.', 'https://media.autoexpress.co.uk/image/private/s--syca4EBx--/v1563183519/autoexpress/2017/12/62vw_8846_fs.jpg', 30100, 2,'https://vectorsart.com/vectors-images/vectorsart_47662.png','Volkswagen', 'Automatico', 2021, 'Diesel', 16, 134);
INSERT INTO automobili (name, description, foto, price, auto_type_id,logo,marca, cambio, anno, carburante, kmL, cavalli) VALUES ('Fiat Doblò', 'Auto di tipo monovolume, spesso classificato come furgone compatto o veicolo commerciale leggero.', 'https://www.fiatprofessional.com/content/dam/fiatprofessional/cross/form/Doblo-form-get-a-quote-desktop-v1_680x450.jpg', 22000, 3, 'https://cdn.freebiesupply.com/logos/large/2x/fiat-3-logo-png-transparent.png','Fiat', 'Manuale', 2019, 'Benzina', 15, 94);
INSERT INTO automobili (name, description, foto, price, auto_type_id,logo,marca, cambio, anno, carburante, kmL, cavalli) VALUES ('BMW Serie 3', 'Auto di lusso apprezzata per il suo design attraente, le prestazioni sportive e le tecnologie avanzate, offrendo un equilibrio tra eleganza e dinamismo.', 'https://th.bing.com/th/id/R.097f845067d1f5dcf220cf950dbf8a69?rik=4WJPrxWDEmERhA&pid=ImgRaw&r=0', 46900, 1, 'https://seeklogo.com/images/B/bmw-logo-248C3D90E6-seeklogo.com.png','Bmw', 'Manuale', 2019, 'Diesel', 16, 143);
INSERT INTO automobili (name, description, foto, price, auto_type_id,logo,marca, cambio, anno, carburante, kmL, cavalli) VALUES ('Jeep Renegade', 'Auto compatta con uno stile distintivo e versatilità, adatto sia alla guida urbana che a esperienze fuoristrada leggere.', 'https://th.bing.com/th/id/OIP.SG6GwW_xahQIbF_gpt83-QHaE8?rs=1&pid=ImgDetMain', 33400, 2, 'https://cdn.freebiesupply.com/logos/large/2x/jeep-7-logo-png-transparent.png','Jeep', 'Manuale', 2018, 'Benzina', 14, 120);
INSERT INTO automobili (name, description, foto, price, auto_type_id,logo,marca, cambio, anno, carburante, kmL, cavalli) VALUES ('Ford Transit', 'Auto commerciale versatile e affidabile, adatto per una vasta gamma di utilizzi, dal trasporto di merci alle navette per passeggeri.', 'https://th.bing.com/th/id/OIP.LepDahhCcqYp7n_YqGEaBQHaFP?rs=1&pid=ImgDetMain', 21490, 3, 'https://cdn.worldvectorlogo.com/logos/ford-logo-flat.svg','Ford', 'Automatio', 2020, 'Diesel', 18, 101);
INSERT INTO automobili (name, description, foto, price, auto_type_id,logo,marca, cambio, anno, carburante, kmL, cavalli) VALUES ('Mercedes-Benz Classe E', 'Auto di lusso che combina eleganza, prestazioni, tecnologia avanzata e comfort. È destinata a coloro che cercano una guida premium con una dose di versatilità grazie alle diverse varianti di carrozzeria disponibili.', 'https://th.bing.com/th/id/OIP.MIW8oAenkm8-umAcYu8YUgHaEf?rs=1&pid=ImgDetMain', 56697, 1, 'https://seeklogo.com/images/M/mercedes-benz-logo-0DCE214555-seeklogo.com.png','Mercedes', 'Manuale', 2021, 'Benzina', 12, 280);
INSERT INTO automobili (name, description, foto, price, auto_type_id,logo,marca, cambio, anno, carburante, kmL, cavalli) VALUES ('Dacia Dokker', 'Auto  multiuso che punta sulla praticità, sulla versatilità e accessibilità economica. È ideale per chi cerca un veicolo funzionale per il trasporto di merci o passeggeri senza dover investire in soluzioni più costose.', 'https://th.bing.com/th/id/OIP.ZucBY277KKL0VxMX3jqVvgHaFj?rs=1&pid=ImgDetMain', 9900, 2, 'https://seeklogo.com/images/D/dacia-logo-26D8DC164A-seeklogo.com.png','Dacia', 'Manuale', 2017, 'Diesel', 14, 78);
INSERT INTO automobili (name, description, foto, price, auto_type_id,logo,marca, cambio, anno, carburante, kmL, cavalli) VALUES ('Cupra Formentor', 'Auto compatta che combina uno stile distintivo con prestazioni sportive e tecnologie avanzate. Si rivolge a coloro che cercano un veicolo sportivo, ma allo stesso tempo pratico e adatto alla guida quotidiana.', 'https://th.bing.com/th/id/R.c1c2dc32bc22d3746657690f4e9ae6d0?rik=cyfedxIjEAUn5Q&pid=ImgRaw&r=0', 31250, 3, 'https://cdn.worldvectorlogo.com/logos/cupra.svg','Cupra', 'Automatico', 2022, 'Benzina', 18, 150);
INSERT INTO automobili (name, description, foto, price, auto_type_id,logo,marca, cambio, anno, carburante, kmL, cavalli) VALUES ('Ferrari 458 Italia', 'La Ferrari 458 Italia è un iconica supercar che incarna la eccellenza nel design e nelle prestazioni automobilistiche. Con linee aerodinamiche affascinanti e uno stile aggressivo, questa vettura esprime la essenza della passione automobilistica italiana.', 'https://cdn.ferrari.com/cms/network/media/img/resize/5db98e9b8c92940b3a3de720-ferrari-458-italia-design-focus-1?', 242000, 4, 'https://seeklogo.com/images/F/ferrari-logo-7935CF173C-seeklogo.com.png','Ferrari', 'Manuale', 2019, 'Benzina', 9, 570);
INSERT INTO automobili (name, description, foto, price, auto_type_id,logo,marca, cambio, anno, carburante, kmL, cavalli) VALUES ('Lamborghini Aventador', 'La Lamborgini è un iconica supercar che incarna la eccellenza nel design e nelle prestazioni automobilistiche. Con linee aerodinamiche affascinanti e uno stile aggressivo, questa vettura esprime la essenza della passione automobilistica italiana.', 'https://cdn.classic-trader.com/I/images/960_720/vehicle_ad_standard_image_109e33a08df2d2d6250380e4b2b0a15e.jpg', 389000, 4, 'https://cdn.worldvectorlogo.com/logos/lamborghini.svg','Lamborghini', 'Manuale', 2020, 'Benzina', 9, 770);
INSERT INTO automobili (name, description, foto, price, auto_type_id,logo,marca, cambio, anno, carburante, kmL, cavalli) VALUES ('Bentley Continental', 'La Bentley è una supercar straordinaria che unisce eleganza e potenza in modo impeccabile. Con il suo design aerodinamico e linee pulite, cattura la attenzione con una eleganza moderna. ', 'https://file.kelleybluebookimages.com/kbb/base/house/2023/2023-Bentley-Continental%20GT-FrontSide_BYCONTGTAZ2301_640x480.jpg', 360000, 4, 'https://seeklogo.com/images/B/bentley-motors-logo-70DEA0C15D-seeklogo.com.png','Bentley', 'Automatico', 2018, 'Benzina', 8, 559);

-- INSERT ACQUISTOFORNITORE
INSERT INTO acquisto_rifornitore (data, quantita, nome_Fornitore, price, auto_id) VALUES ('2021-01-25', 2, 'Mercedes-Benz Italia S.p.a.', 42000, 7);
INSERT INTO acquisto_rifornitore (data, quantita, nome_Fornitore, price, auto_id) VALUES ('2023-06-13', 1, 'BMW Italia S.p.a.', 36000, 4);
INSERT INTO acquisto_rifornitore (data, quantita, nome_Fornitore, price, auto_id) VALUES ('2024-01-02', 4, 'Stellantis Group Italia S.P.A.', 16000, 5);
INSERT INTO acquisto_rifornitore (data, quantita, nome_Fornitore, price, auto_id) VALUES ('2023-11-07', 5, 'Ford Italia S.p.a.', 10000, 6);
INSERT INTO acquisto_rifornitore (data, quantita, nome_Fornitore, price, auto_id) VALUES ('2024-03-11', 3, 'Stellantis Group Italia S.P.A.', 11000, 3);
INSERT INTO acquisto_rifornitore (data, quantita, nome_Fornitore, price, auto_id) VALUES ('2023-03-22', 2, 'Gruppo Volkswagen Italia S.P.A.', 14000, 1);
INSERT INTO acquisto_rifornitore (data, quantita, nome_Fornitore, price, auto_id) VALUES ('2023-04-15', 2, 'Gruppo Volkswagen Italia S.P.A.', 150000, 12);
INSERT INTO acquisto_rifornitore (data, quantita, nome_Fornitore, price, auto_id) VALUES ('2024-02-01', 4, 'Gruppo Volkswagen Italia S.P.A.', 18000, 2);
INSERT INTO acquisto_rifornitore (data, quantita, nome_Fornitore, price, auto_id) VALUES ('2022-05-05', 6, 'Renault Italia S.P.A.', 4500, 8);
INSERT INTO acquisto_rifornitore (data, quantita, nome_Fornitore, price, auto_id) VALUES ('2023-09-18', 3, 'Seat Italia S.P.A.', 19500, 9);
INSERT INTO acquisto_rifornitore (data, quantita, nome_Fornitore, price, auto_id) VALUES ('2022-10-12', 1, 'Lamborghini Italia S.P.A.', 220000, 11);
INSERT INTO acquisto_rifornitore (data, quantita, nome_Fornitore, price, auto_id) VALUES ('2023-12-16', 1, 'Ferrari Italia S.P.A.', 112000, 10);

-- INSERT ACQUISTOCLIENTE
INSERT INTO acquisto_cliente (auto_id, `data`,quantita) VALUES(1, '2024-01-29', 3);
INSERT INTO acquisto_cliente (auto_id, `data`,quantita) VALUES(2, '2024-01-29', 5);
INSERT INTO acquisto_cliente (auto_id, `data`,quantita) VALUES(1, '2024-01-29', 2);
INSERT INTO acquisto_cliente (auto_id, `data`,quantita) VALUES(1, '2024-01-29', 6);
INSERT INTO acquisto_cliente (auto_id, `data`,quantita) VALUES(7, '2024-01-29', 3);
INSERT INTO acquisto_cliente (auto_id, `data`,quantita) VALUES(9, '2024-01-29', 18);

-- INSERT ROLE
INSERT INTO `role` (name) VALUES('ADMIN');
INSERT INTO `role` (name) VALUES('USER');

-- INSERT USER
INSERT INTO auto_user (password, username) VALUES('Alfredo', '{noop}Alfredo');
INSERT INTO auto_user (password, username) VALUES('Alessandro', '{noop}Alessandro');
INSERT INTO auto_user (password, username) VALUES('Marco', '{noop}Marco');
INSERT INTO auto_user (password, username) VALUES('Ganni', '{noop}Ganni');

-- INSERT SET-ROLE
INSERT INTO auto_user_role_set (auto_user_id, role_set_name) VALUES(1, 'ADMIN');
INSERT INTO auto_user_role_set (auto_user_id, role_set_name) VALUES(1, 'USER');
INSERT INTO auto_user_role_set (auto_user_id, role_set_name) VALUES(2, 'ADMIN');
INSERT INTO auto_user_role_set (auto_user_id, role_set_name) VALUES(2, 'USER');
INSERT INTO auto_user_role_set (auto_user_id, role_set_name) VALUES(3, 'USER');
INSERT INTO auto_user_role_set (auto_user_id, role_set_name) VALUES(4, 'USER');