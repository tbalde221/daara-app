package sn.tbalde.daara_app;

import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sn.tbalde.daara_app.entities.Classe;
import sn.tbalde.daara_app.entities.Maitre;
import sn.tbalde.daara_app.enums.Niveau;
import sn.tbalde.daara_app.repositories.ClasseRepository;
import sn.tbalde.daara_app.repositories.MaitreRepository;

@SpringBootApplication
public class DaaraAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaaraAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(MaitreRepository maitreRepository, ClasseRepository classeRepository) {

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
			Classe c1 = Classe.builder()
					.codeClasse("CL001")
					.libelle("Classe Coranique 1")
					.niveau(Niveau.DEBUTANT)
					.maitre(m1)
					.build();

			Classe c2 = Classe.builder()
					.codeClasse("CL002")
					.libelle("Classe Coranique 2")
					.niveau(Niveau.DEBUTANT)
					.maitre(m2)
					.build();

			Classe c3 = Classe.builder()
					.codeClasse("CL003")
					.libelle("Classe Coranique 3")
					.niveau(Niveau.DEBUTANT)
					.maitre(m3)
					.build();

			Classe c4 = Classe.builder()
					.codeClasse("CL004")
					.libelle("Classe Coranique 4")
					.niveau(Niveau.INTERMEDIAIRE)
					.maitre(m4)
					.build();

			Classe c5 = Classe.builder()
					.codeClasse("CL005")
					.libelle("Classe Coranique 5")
					.niveau(Niveau.INTERMEDIAIRE)
					.maitre(m5)
					.build();

			Classe c6 = Classe.builder()
					.codeClasse("CL006")
					.libelle("Classe Coranique 6")
					.niveau(Niveau.INTERMEDIAIRE)
					.maitre(m6)
					.build();

			Classe c7 = Classe.builder()
					.codeClasse("CL007")
					.libelle("Classe Coranique 7")
					.niveau(Niveau.INTERMEDIAIRE)
					.maitre(m7)
					.build();

			Classe c8 = Classe.builder()
					.codeClasse("CL008")
					.libelle("Classe Coranique 8")
					.niveau(Niveau.AVANCE)
					.maitre(m8)
					.build();

			Classe c9 = Classe.builder()
					.codeClasse("CL009")
					.libelle("Classe Coranique 9")
					.niveau(Niveau.AVANCE)
					.maitre(m9)
					.build();

			Classe c10 = Classe.builder()
					.codeClasse("CL010")
					.libelle("Classe Coranique 10")
					.niveau(Niveau.AVANCE)
					.maitre(m10)
					.build();
			maitreRepository.saveAll(List.of(
					m1, m2, m3, m4, m5,
					m6, m7, m8, m9, m10,
					m11, m12, m13, m14, m15));
			classeRepository.saveAll(List.of(
					c1, c2, c3, c4, c5,
					c6, c7, c8, c9, c10));

		};

	}

}
