
-- INSERT AUTOTYPE
INSERT INTO type (name, descrizione) VALUES ('Coupé', 'Auto a due porte e tetto fisso. Il volume della parte posteriore è ridotto a favore di una linea più sportiva (meno spazio per passeggeri posteriori e bagagli).');
INSERT INTO type (name, descrizione) VALUES ('Suv', 'Auto progettata per offrire una combinazione di caratteristiche di un veicolo fuoristrada e di una berlina tradizionale');
INSERT INTO type (name, descrizione) VALUES ('Van', 'Auto progettata principalmente per il trasporto di merci o passeggeri.');
INSERT INTO type (name, descrizione) VALUES ('Sportive', 'Auto progettata offrire prestazioni sopra la media, con dei design areodinamici e leggeri.');

-- INSERT AUTO
INSERT INTO automobili (name, description, foto, price, auto_type_id) VALUES ('Audi A1', 'Auto sportiva e tecnologica, con interni curati e tanto spazio a bordo. Il design è accattivante e grintoso, con un profilo slanciato e un assetto ribassato per una perfetta tenuta di strada.', 'https://th.bing.com/th/id/OIP.iU6Fiq_s0sAg8Kf-iWTWAQHaEK?rs=1&pid=ImgDetMain', 25800, 1);
INSERT INTO automobili (name, description, foto, price, auto_type_id) VALUES ('T-Roc', 'Il Volkswagen T-Roc è un SUV compatto prodotto dalla casa automobilistica tedesca Volkswagen. Lanciato nel 2017, il T-Roc si distingue per il suo design moderno e sportivo.', 'https://media.autoexpress.co.uk/image/private/s--syca4EBx--/v1563183519/autoexpress/2017/12/62vw_8846_fs.jpg', 30100, 2);
INSERT INTO automobili (name, description, foto, price, auto_type_id) VALUES ('Fiat Doblò', 'Auto di tipo monovolume, spesso classificato come furgone compatto o veicolo commerciale leggero.', 'https://th.bing.com/th/id/OIP.FMgguWsuXg0GencpKZebpQHaD4?rs=1&pid=ImgDetMain', 22000, 3);
INSERT INTO automobili (name, description, foto, price, auto_type_id) VALUES ('BMW Serie 3', 'Auto di lusso apprezzata per il suo design attraente, le prestazioni sportive e le tecnologie avanzate, offrendo un equilibrio tra eleganza e dinamismo.', 'https://th.bing.com/th/id/R.097f845067d1f5dcf220cf950dbf8a69?rik=4WJPrxWDEmERhA&pid=ImgRaw&r=0', 46900, 1);
INSERT INTO automobili (name, description, foto, price, auto_type_id) VALUES ('Jeep Renegade', 'Auto compatta con uno stile distintivo e versatilità, adatto sia alla guida urbana che a esperienze fuoristrada leggere.', 'https://th.bing.com/th/id/OIP.SG6GwW_xahQIbF_gpt83-QHaE8?rs=1&pid=ImgDetMain', 33400, 2);
INSERT INTO automobili (name, description, foto, price, auto_type_id) VALUES ('Ford Transit', 'Auto commerciale versatile e affidabile, adatto per una vasta gamma di utilizzi, dal trasporto di merci alle navette per passeggeri.', 'https://th.bing.com/th/id/OIP.LepDahhCcqYp7n_YqGEaBQHaFP?rs=1&pid=ImgDetMain', 21490, 3);
INSERT INTO automobili (name, description, foto, price, auto_type_id) VALUES ('Mercedes-Benz Classe E', 'Auto di lusso che combina eleganza, prestazioni, tecnologia avanzata e comfort. È destinata a coloro che cercano una guida premium con una dose di versatilità grazie alle diverse varianti di carrozzeria disponibili.', 'https://th.bing.com/th/id/OIP.MIW8oAenkm8-umAcYu8YUgHaEf?rs=1&pid=ImgDetMain', 56697, 1);
INSERT INTO automobili (name, description, foto, price, auto_type_id) VALUES ('Dacia Dokker', 'Auto  multiuso che punta sulla praticità, sulla versatilità e accessibilità economica. È ideale per chi cerca un veicolo funzionale per il trasporto di merci o passeggeri senza dover investire in soluzioni più costose.', 'https://th.bing.com/th/id/OIP.ZucBY277KKL0VxMX3jqVvgHaFj?rs=1&pid=ImgDetMain', 9900, 2);
INSERT INTO automobili (name, description, foto, price, auto_type_id) VALUES ('Cupra Formentor', 'Auto compatta che combina uno stile distintivo con prestazioni sportive e tecnologie avanzate. Si rivolge a coloro che cercano un veicolo sportivo, ma allo stesso tempo pratico e adatto alla guida quotidiana.', 'https://th.bing.com/th/id/R.c1c2dc32bc22d3746657690f4e9ae6d0?rik=cyfedxIjEAUn5Q&pid=ImgRaw&r=0', 31250, 3);
INSERT INTO automobili (name, description, foto, price, auto_type_id) VALUES ('Ferrari 458 Italia', 'La Ferrari 458 Italia è un iconica supercar che incarna la eccellenza nel design e nelle prestazioni automobilistiche. Con linee aerodinamiche affascinanti e uno stile aggressivo, questa vettura esprime la essenza della passione automobilistica italiana.', 'https://cdn.ferrari.com/cms/network/media/img/resize/5db98e9b8c92940b3a3de720-ferrari-458-italia-design-focus-1?', 240000, 4);
INSERT INTO automobili (name, description, foto, price, auto_type_id) VALUES ('Lamborghini Aventador', 'La Lamborgini è un iconica supercar che incarna la eccellenza nel design e nelle prestazioni automobilistiche. Con linee aerodinamiche affascinanti e uno stile aggressivo, questa vettura esprime la essenza della passione automobilistica italiana.', 'https://cdn.classic-trader.com/I/images/960_720/vehicle_ad_standard_image_109e33a08df2d2d6250380e4b2b0a15e.jpg', 400000, 4);
INSERT INTO automobili (name, description, foto, price, auto_type_id) VALUES ('Audi R8', 'La Audi R8 è una supercar straordinaria che unisce eleganza e potenza in modo impeccabile. Con il suo design aerodinamico e linee pulite, cattura la attenzione con una eleganza moderna. ', 'https://cdn.motor1.com/images/mgl/BqPZM/s3/2021-audi-r8-rwd-panther-edition.webp', 220000, 4);

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

