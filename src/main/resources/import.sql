-- INSERT AUTO
INSERT INTO automobili (name, description, foto, price) VALUES ('Audi A1', 'E un’auto sportiva e tecnologica, con interni curati e tanto spazio a bordo. Il design è accattivante e grintoso, con un profilo slanciato e un assetto ribassato per una perfetta tenuta di strada.', 'https://th.bing.com/th/id/OIP.iU6Fiq_s0sAg8Kf-iWTWAQHaEK?rs=1&pid=ImgDetMain', 25800);
INSERT INTO automobili (name, description, foto, price) VALUES ('T-Roc', 'Il Volkswagen T-Roc è un SUV compatto prodotto dalla casa automobilistica tedesca Volkswagen. Lanciato nel 2017, il T-Roc si distingue per il suo design moderno e sportivo.', 'https://media.autoexpress.co.uk/image/private/s--syca4EBx--/v1563183519/autoexpress/2017/12/62vw_8846_fs.jpg', 30100);
INSERT INTO automobili (name, description, foto, price) VALUES ('Fiat Doblò', 'Auto di tipo monovolume, spesso classificato come furgone compatto o veicolo commerciale leggero.', 'https://th.bing.com/th/id/OIP.FMgguWsuXg0GencpKZebpQHaD4?rs=1&pid=ImgDetMain', 22000);
INSERT INTO automobili (name, description, foto, price) VALUES ('BMW Serie 3', 'Auto di lusso apprezzata per il suo design attraente, le prestazioni sportive e le tecnologie avanzate, offrendo un equilibrio tra eleganza e dinamismo.', 'https://th.bing.com/th/id/R.097f845067d1f5dcf220cf950dbf8a69?rik=4WJPrxWDEmERhA&pid=ImgRaw&r=0', 46900);
INSERT INTO automobili (name, description, foto, price) VALUES ('Jeep Renegade', 'Auto compatta con uno stile distintivo e versatilità, adatto sia alla guida urbana che a esperienze fuoristrada leggere.', 'https://th.bing.com/th/id/OIP.SG6GwW_xahQIbF_gpt83-QHaE8?rs=1&pid=ImgDetMain', 33400);
INSERT INTO automobili (name, description, foto, price) VALUES ('Ford Transit', 'Auto commerciale versatile e affidabile, adatto per una vasta gamma di utilizzi, dal trasporto di merci alle navette per passeggeri.', 'https://th.bing.com/th/id/OIP.LepDahhCcqYp7n_YqGEaBQHaFP?rs=1&pid=ImgDetMain', 21490);
INSERT INTO automobili (name, description, foto, price) VALUES ('Mercedes-Benz Classe E', 'Auto di lusso che combina eleganza, prestazioni, tecnologia avanzata e comfort. È destinata a coloro che cercano una guida premium con una dose di versatilità grazie alle diverse varianti di carrozzeria disponibili.', 'https://th.bing.com/th/id/OIP.MIW8oAenkm8-umAcYu8YUgHaEf?rs=1&pid=ImgDetMain', 56697);
INSERT INTO automobili (name, description, foto, price) VALUES ('Dacia Dokker', 'Auto  multiuso che punta sulla praticità, sulla versatilità e accessibilità economica. È ideale per chi cerca un veicolo funzionale per il trasporto di merci o passeggeri senza dover investire in soluzioni più costose.', 'https://th.bing.com/th/id/OIP.ZucBY277KKL0VxMX3jqVvgHaFj?rs=1&pid=ImgDetMain', 9900);
INSERT INTO automobili (name, description, foto, price) VALUES ('Cupra Formentor', 'Auto compatta che combina uno stile distintivo con prestazioni sportive e tecnologie avanzate. Si rivolge a coloro che cercano un veicolo sportivo, ma allo stesso tempo pratico e adatto alla guida quotidiana.', 'https://th.bing.com/th/id/R.c1c2dc32bc22d3746657690f4e9ae6d0?rik=cyfedxIjEAUn5Q&pid=ImgRaw&r=0', 31250);


-- INSERT AUTOTYPE
INSERT INTO type (name, descrizione) VALUES ('Coupé', 'Auto a due porte e tetto fisso. Il volume della parte posteriore è ridotto a favore di una linea più sportiva (meno spazio per passeggeri posteriori e bagagli).');
INSERT INTO type (name, descrizione) VALUES ('Suv', 'Auto progettata per offrire una combinazione di caratteristiche di un veicolo fuoristrada e di una berlina tradizionale');
INSERT INTO type (name, descrizione) VALUES ('Van', 'Auto progettata principalmente per il trasporto di merci o passeggeri.');


-- INSERT ACQUISTOFORNITORE
INSERT INTO acquisto_rifornitore (data, quantità, nome_Fornitore, price, auto_id) VALUES ('2021-01-25', 2, 'Mercedes-Benz Italia S.p.a.', 77000, 1);
INSERT INTO acquisto_rifornitore (data, quantità, nome_Fornitore, price, auto_id) VALUES ('2023-06-13', 1, 'BMW Italia S.p.a.', 42000, 3);
INSERT INTO acquisto_rifornitore (data, quantità, nome_Fornitore, price, auto_id) VALUES ('2024-01-02', 4, 'Volkswagen Group Italia S.P.A.', 102000, 2);
INSERT INTO acquisto_rifornitore (data, quantità, nome_Fornitore, price, auto_id) VALUES ('2023-11-07', 5, 'Ford Italia S.p.a.', 123000, 1);