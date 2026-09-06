package sn.tbalde.daara_app;

import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sn.tbalde.daara_app.entities.Maitre;
import sn.tbalde.daara_app.repositories.MaitreRepository;

@SpringBootApplication
public class DaaraAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaaraAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(MaitreRepository maitreRepository) {

		return args -> {

			Maitre m1 = Maitre.builder()
					.nom("BALDE")
					.prenom("Thierno")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("771867959")
					.build();

			Maitre m2 = Maitre.builder()
					.nom("BAH")
					.prenom("Adama Sadio")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("701542348")
					.build();

			Maitre m3 = Maitre.builder()
					.nom("DIOP")
					.prenom("Mamadou")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("772345678")
					.build();

			Maitre m4 = Maitre.builder()
					.nom("FALL")
					.prenom("Abdoulaye")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("763456789")
					.build();

			Maitre m5 = Maitre.builder()
					.nom("NDIAYE")
					.prenom("Ibrahima")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("784567890")
					.build();

			Maitre m6 = Maitre.builder()
					.nom("SOW")
					.prenom("Oumar")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("775678901")
					.build();

			Maitre m7 = Maitre.builder()
					.nom("SY")
					.prenom("Moustapha")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("706789012")
					.build();

			Maitre m8 = Maitre.builder()
					.nom("GUEYE")
					.prenom("Cheikh")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("717890123")
					.build();

			Maitre m9 = Maitre.builder()
					.nom("SECK")
					.prenom("Modou")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("728901234")
					.build();

			Maitre m10 = Maitre.builder()
					.nom("DIALLO")
					.prenom("Mamadou Aliou")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("779012345")
					.build();

			Maitre m11 = Maitre.builder()
					.nom("BA")
					.prenom("Ousmane")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("760123456")
					.build();

			Maitre m12 = Maitre.builder()
					.nom("CAMARA")
					.prenom("Alpha")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("781234567")
					.build();

			Maitre m13 = Maitre.builder()
					.nom("TOURE")
					.prenom("Abdou")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("792345678")
					.build();

			Maitre m14 = Maitre.builder()
					.nom("KANE")
					.prenom("Amadou")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("703456789")
					.build();

			Maitre m15 = Maitre.builder()
					.nom("THIAM")
					.prenom("Serigne")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("714567890")
					.build();

			Maitre m16 = Maitre.builder()
					.nom("LO")
					.prenom("Papa")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("725678901")
					.build();

			Maitre m17 = Maitre.builder()
					.nom("DIOUF")
					.prenom("Moussa")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("736789012")
					.build();

			Maitre m18 = Maitre.builder()
					.nom("MBAYE")
					.prenom("Alioune")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("747890123")
					.build();

			Maitre m19 = Maitre.builder()
					.nom("FAYE")
					.prenom("Cheikh Ahmadou")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("758901234")
					.build();

			Maitre m20 = Maitre.builder()
					.nom("CISSE")
					.prenom("Abdoul Aziz")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("769012345")
					.build();

			Maitre m21 = Maitre.builder()
					.nom("GNINGUE")
					.prenom("Mamadou")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("770123456")
					.build();

			Maitre m22 = Maitre.builder()
					.nom("WANE")
					.prenom("Abdou")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("781234890")
					.build();

			Maitre m23 = Maitre.builder()
					.nom("DIAGNE")
					.prenom("Saliou")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("792345901")
					.build();

			Maitre m24 = Maitre.builder()
					.nom("NIANG")
					.prenom("Babacar")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("703456890")
					.build();

			Maitre m25 = Maitre.builder()
					.nom("KONATE")
					.prenom("Moussa")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("714567901")
					.build();

			Maitre m26 = Maitre.builder()
					.nom("TRAORE")
					.prenom("Ibrahima")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("725678012")
					.build();

			Maitre m27 = Maitre.builder()
					.nom("DANSOKHO")
					.prenom("Oumar")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("736789123")
					.build();

			Maitre m28 = Maitre.builder()
					.nom("KEBE")
					.prenom("Moustapha")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("747890234")
					.build();

			Maitre m29 = Maitre.builder()
					.nom("SYLLA")
					.prenom("Abdoulaye")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("758901345")
					.build();

			Maitre m30 = Maitre.builder()
					.nom("DIA")
					.prenom("Amadou")
					.idMaitre(UUID.randomUUID().toString())
					.telephone("769012456")
					.build();

			maitreRepository.saveAll(List.of(
					m1, m2, m3, m4, m5,
					m6, m7, m8, m9, m10,
					m11, m12, m13, m14, m15,
					m16, m17, m18, m19, m20,
					m21, m22, m23, m24, m25,
					m26, m27, m28, m29, m30));

		};
	}

}
