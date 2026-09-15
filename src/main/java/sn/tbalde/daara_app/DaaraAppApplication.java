package sn.tbalde.daara_app;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sn.tbalde.daara_app.entities.Classe;
import sn.tbalde.daara_app.entities.Maitre;
import sn.tbalde.daara_app.entities.Progression;
import sn.tbalde.daara_app.entities.Talibe;
import sn.tbalde.daara_app.enums.Niveau;
import sn.tbalde.daara_app.repositories.ClasseRepository;
import sn.tbalde.daara_app.repositories.MaitreRepository;
import sn.tbalde.daara_app.repositories.ProgressionRepository;
import sn.tbalde.daara_app.repositories.TalibeRepository;

@SpringBootApplication
public class DaaraAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaaraAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(MaitreRepository maitreRepository, ClasseRepository classeRepository,
			TalibeRepository talibeRepository, ProgressionRepository progressionRepository) {

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

			Talibe t1 = Talibe.builder()
					.idTalibe(UUID.randomUUID().toString())
					.prenom("Modou")
					.nom("DIENG")
					.dateNaissance(new SimpleDateFormat("yyyy-MM-dd").parse("2012-03-14"))
					.nomTuteur("Ibrahima DIENG")
					.telephoneTuteur("773456712")
					.classe(c1)
					.build();

			Talibe t2 = Talibe.builder()
					.idTalibe(UUID.randomUUID().toString())
					.prenom("Cheikh")
					.nom("NIANG")
					.dateNaissance(new SimpleDateFormat("yyyy-MM-dd").parse("2011-07-22"))
					.nomTuteur("Aissatou NIANG")
					.telephoneTuteur("704567823")
					.classe(c2)
					.build();

			Talibe t3 = Talibe.builder()
					.idTalibe(UUID.randomUUID().toString())
					.prenom("Ousmane")
					.nom("SARR")
					.dateNaissance(new SimpleDateFormat("yyyy-MM-dd").parse("2013-01-05"))
					.nomTuteur("Fatou SARR")
					.telephoneTuteur("765678934")
					.classe(c3)
					.build();

			Talibe t4 = Talibe.builder()
					.idTalibe(UUID.randomUUID().toString())
					.prenom("Amadou")
					.nom("LO")
					.dateNaissance(new SimpleDateFormat("yyyy-MM-dd").parse("2012-09-30"))
					.nomTuteur("Mamadou LO")
					.telephoneTuteur("786789045")
					.classe(c4)
					.build();

			Talibe t5 = Talibe.builder()
					.idTalibe(UUID.randomUUID().toString())
					.prenom("Serigne")
					.nom("MBAYE")
					.dateNaissance(new SimpleDateFormat("yyyy-MM-dd").parse("2010-11-18"))
					.nomTuteur("Astou MBAYE")
					.telephoneTuteur("707890156")
					.classe(c5)
					.build();

			Talibe t6 = Talibe.builder()
					.idTalibe(UUID.randomUUID().toString())
					.prenom("Ibrahima")
					.nom("FAYE")
					.dateNaissance(new SimpleDateFormat("yyyy-MM-dd").parse("2011-04-09"))
					.nomTuteur("Modou FAYE")
					.telephoneTuteur("778901267")
					.classe(c6)
					.build();

			Talibe t7 = Talibe.builder()
					.idTalibe(UUID.randomUUID().toString())
					.prenom("Abdoulaye")
					.nom("GOMIS")
					.dateNaissance(new SimpleDateFormat("yyyy-MM-dd").parse("2012-06-25"))
					.nomTuteur("Khady GOMIS")
					.telephoneTuteur("709012378")
					.classe(c7)
					.build();

			Talibe t8 = Talibe.builder()
					.idTalibe(UUID.randomUUID().toString())
					.prenom("Mor")
					.nom("SENE")
					.dateNaissance(new SimpleDateFormat("yyyy-MM-dd").parse("2013-02-12"))
					.nomTuteur("Rokhaya SENE")
					.telephoneTuteur("770123489")
					.classe(c8)
					.build();

			Talibe t9 = Talibe.builder()
					.idTalibe(UUID.randomUUID().toString())
					.prenom("Pape")
					.nom("DIATTA")
					.dateNaissance(new SimpleDateFormat("yyyy-MM-dd").parse("2011-12-01"))
					.nomTuteur("Bineta DIATTA")
					.telephoneTuteur("761234590")
					.classe(c9)
					.build();

			Talibe t10 = Talibe.builder()
					.idTalibe(UUID.randomUUID().toString())
					.prenom("Malick")
					.nom("SYLLA")
					.dateNaissance(new SimpleDateFormat("yyyy-MM-dd").parse("2010-08-17"))
					.nomTuteur("Aminata SYLLA")
					.telephoneTuteur("782345601")
					.classe(c10)
					.build();

			Progression p1 = Progression.builder()
					.idProgression(UUID.randomUUID().toString())
					.sourate("Al-Fatiha")
					.nombreVersets(7)
					.dateEvaluation(new SimpleDateFormat("yyyy-MM-dd").parse("2026-01-15"))
					.apreciation("Excellent")
					.talibe(t1)
					.build();

			Progression p2 = Progression.builder()
					.idProgression(UUID.randomUUID().toString())
					.sourate("Al-Baqara")
					.nombreVersets(20)
					.dateEvaluation(new SimpleDateFormat("yyyy-MM-dd").parse("2026-02-10"))
					.apreciation("Bien")
					.talibe(t2)
					.build();

			Progression p3 = Progression.builder()
					.idProgression(UUID.randomUUID().toString())
					.sourate("Ali-Imran")
					.nombreVersets(15)
					.dateEvaluation(new SimpleDateFormat("yyyy-MM-dd").parse("2026-01-28"))
					.apreciation("Assez bien")
					.talibe(t3)
					.build();

			Progression p4 = Progression.builder()
					.idProgression(UUID.randomUUID().toString())
					.sourate("An-Nisa")
					.nombreVersets(25)
					.dateEvaluation(new SimpleDateFormat("yyyy-MM-dd").parse("2026-03-05"))
					.apreciation("Excellent")
					.talibe(t4)
					.build();

			Progression p5 = Progression.builder()
					.idProgression(UUID.randomUUID().toString())
					.sourate("Al-Maida")
					.nombreVersets(10)
					.dateEvaluation(new SimpleDateFormat("yyyy-MM-dd").parse("2026-02-19"))
					.apreciation("Bien")
					.talibe(t5)
					.build();

			Progression p6 = Progression.builder()
					.idProgression(UUID.randomUUID().toString())
					.sourate("Al-Anam")
					.nombreVersets(18)
					.dateEvaluation(new SimpleDateFormat("yyyy-MM-dd").parse("2026-01-22"))
					.apreciation("Moyen")
					.talibe(t6)
					.build();

			Progression p7 = Progression.builder()
					.idProgression(UUID.randomUUID().toString())
					.sourate("Al-Araf")
					.nombreVersets(30)
					.dateEvaluation(new SimpleDateFormat("yyyy-MM-dd").parse("2026-03-12"))
					.apreciation("Excellent")
					.talibe(t7)
					.build();

			Progression p8 = Progression.builder()
					.idProgression(UUID.randomUUID().toString())
					.sourate("Al-Anfal")
					.nombreVersets(12)
					.dateEvaluation(new SimpleDateFormat("yyyy-MM-dd").parse("2026-02-27"))
					.apreciation("Bien")
					.talibe(t8)
					.build();

			Progression p9 = Progression.builder()
					.idProgression(UUID.randomUUID().toString())
					.sourate("At-Tawba")
					.nombreVersets(22)
					.dateEvaluation(new SimpleDateFormat("yyyy-MM-dd").parse("2026-01-30"))
					.apreciation("Assez bien")
					.talibe(t9)
					.build();

			Progression p10 = Progression.builder()
					.idProgression(UUID.randomUUID().toString())
					.sourate("Yunus")
					.nombreVersets(9)
					.dateEvaluation(new SimpleDateFormat("yyyy-MM-dd").parse("2026-03-08"))
					.apreciation("Excellent")
					.talibe(t10)
					.build();

			talibeRepository.saveAll(List.of(
					t1, t2, t3, t4, t5,
					t6, t7, t8, t9, t10));
			progressionRepository.saveAll(List.of(
					p1, p2, p3, p4, p5,
					p6, p7, p8, p9, p10));

		};

	}

}
