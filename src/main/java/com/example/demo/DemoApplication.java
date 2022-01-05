package com.example.demo;

import com.example.demo.domain.*;
import com.example.demo.repository.ArticleImageService;
import com.example.demo.service.article.ArticleCategoryService;
import com.example.demo.service.article.ArticleService;
import com.example.demo.service.article.ArticleSubCategoryService;
import com.example.demo.service.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(
		UserService userService,
		ArticleService articleService,
		ArticleCategoryService articleCategoryService,
		ArticleSubCategoryService articleSubCategoryService,
		ArticleImageService articleImageService
	) {

		return args -> {

			// article
			ArticleImage image1 = articleImageService.save(new ArticleImage(null, "https://ci.jumia.is/unsafe/fit-in/500x500/filters:fill(white)/product/74/718441/1.jpg?6102"));
			ArticleImage image2 = articleImageService.save(new ArticleImage(null, "https://ci.jumia.is/unsafe/fit-in/500x500/filters:fill(white)/product/63/718441/1.jpg?6723"));
			ArticleImage image3 = articleImageService.save(new ArticleImage(null, "https://ci.jumia.is/unsafe/fit-in/500x500/filters:fill(white)/product/35/507251/1.jpg?0023"));
			ArticleImage image4 = articleImageService.save(new ArticleImage(null, "https://ci.jumia.is/unsafe/fit-in/500x500/filters:fill(white)/product/97/639241/1.jpg?9624"));
			ArticleImage image5 = articleImageService.save(new ArticleImage(null, "https://ci.jumia.is/unsafe/fit-in/500x500/filters:fill(white)/product/52/632561/1.jpg?4946"));
			ArticleImage image6 = articleImageService.save(new ArticleImage(null, "https://ci.jumia.is/unsafe/fit-in/500x500/filters:fill(white)/product/72/772561/1.jpg?5358"));
			ArticleImage image7 = articleImageService.save(new ArticleImage(null, "https://ci.jumia.is/unsafe/fit-in/500x500/filters:fill(white)/product/35/357151/1.jpg?7071"));
			ArticleImage image8 = articleImageService.save(new ArticleImage(null, "https://ci.jumia.is/unsafe/fit-in/500x500/filters:fill(white)/product/40/617341/1.jpg?0687"));

			ArticleCategory cateogry1 = articleCategoryService.saveArticleCategory(new ArticleCategory(null, "chambre"));
			ArticleCategory cateogry2 = articleCategoryService.saveArticleCategory(new ArticleCategory(null, "bureau"));

			ArticleSubCategory subCategory1 = articleSubCategoryService.saveArticleSubCategory(new ArticleSubCategory(null, "armoire de chambre", cateogry1));
			ArticleSubCategory subCategory2 = articleSubCategoryService.saveArticleSubCategory(new ArticleSubCategory(null, "lit de chambre", cateogry1));
			ArticleSubCategory subCategory3 = articleSubCategoryService.saveArticleSubCategory(new ArticleSubCategory(null, "chaise de bureau", cateogry2));
			ArticleSubCategory subCategory4 = articleSubCategoryService.saveArticleSubCategory(new ArticleSubCategory(null, "table de bureau", cateogry2));

			articleService.saveArticle(new Article(
				null,
				"Commode Armoire De Rangement 12 Compartiments + 3 Pour Chaussures",
				"Cette armoire a grande capacité permet de ranger parfaitement les vêtements; chaussures ;  jouets et autres accessoires.Bonne stabilité Les plaques en PP plastique, encadrées par le fil en fer, sont attachées par les pièces de fixation en ABS, ce qui assure la bonne résistance et la bonne charge de chaque cube .Montage facile Grâce à sa structure les plaques et les pièces fournir vous assure un montage très simple. Il est facile à nettoyer et maintenir -imperméable a l'eau ; résistant a la moisissure et a la poussière .",
				39900.0,
				5,
				image1,
				subCategory1,
				System.currentTimeMillis(),
				System.currentTimeMillis())
			);
			articleService.saveArticle(new Article(
				null,
				"Commode Armoire De Rangement 10 Compartiments",
				"Cette armoire a grande capacité permet de ranger parfaitement les vêtements; chaussures ;  jouets et autres accessoires.\n" +
						"Bonne stabilité \n" +
						"Les plaques en PP plastique, encadrées par le fil en fer, sont attachées par les pièces de fixation en ABS, ce qui assure la bonne résistance et la bonne charge de chaque cube .\n" +
						"Montage facile \n" +
						"Grâce à sa structure les plaques et les pièces fournir vous assure un montage très simple. Il est facile à nettoyer et maintenir -imperméable a l'eau ; résistant a la moisissure et a la poussière .",
				39900.0,
				5,
				image2,
				subCategory1,
				System.currentTimeMillis(),
				System.currentTimeMillis())
			);
			articleService.saveArticle(new Article(
				null,
				"Lit Adulte 2 Places+matelas+2caissons",
				"Pour les chambres d’adulte, le lit 2 places est central et constitue la pièce maîtresse du mobilier. Il donne le ton à l’ambiance souhaitée. Certains lits doubles sont en bois massifs, imposants et teintés d’exotisme. D’autres, jouent sur les mélanges de matières et de couleurs et inspirent une ambiance plus contemporaine. Quel que soit le choix du lit, il détermine l’atmosphère de la chambre.",
				530000.0,
				5,
				image3,
				subCategory2,
				System.currentTimeMillis(),
				System.currentTimeMillis())
			);
			articleService.saveArticle(new Article(
				null,
				"LIT DE 2 PLACES Double Dimension : 140×190 – Milticouleur",
				"Pour les chambres d’adulte, le lit 2 places est central et constitue la pièce maîtresse du mobilier. Il donne le ton à l’ambiance souhaitée. Certains lits doubles sont en bois massifs, imposants et teintés d’exotisme. D’autres, jouent sur les mélanges de matières et de couleurs et inspirent une ambiance plus contemporaine. Quel que soit le choix du lit, il détermine l’atmosphère de la chambre.*Pour les chambres d’adulte, le lit 2 places est central et constitue la pièce maîtresse du mobilier. Il donne le ton à l’ambiance souhaitée. Certains lits doubles sont en bois massifs, imposants et teintés d’exotisme. D’autres, jouent sur les mélanges de matières et de couleurs et inspirent une ambiance plus contemporaine. Quel que soit le choix du lit, il détermine l’atmosphère de la chambre.",
				2115600.0,
				5,
				image4,
				subCategory2,
				System.currentTimeMillis(),
				System.currentTimeMillis())
			);
			articleService.saveArticle(new Article(
				null,
				"Thickened Fleece Rice Elastic Comfortable Chair Cover With Elastic Bandage-Bean Green",
				"This chair cover is not irritating, and it is colorful, natural beauty, soft touch, natural, environmental friendly and comfortable, and cover it directly, it is easy and convenient to carry and use.",
				7213.0,
				5,
				image5,
				subCategory3,
				System.currentTimeMillis(),
				System.currentTimeMillis())
			);
			articleService.saveArticle(new Article(
				null,
				"Thickened Fleece Rice Elastic Comfortable Chair Cover With Elastic Bandage-Navy",
				"This chair cover is not irritating, and it is colorful, natural beauty, soft touch, natural, environmental friendly and comfortable, and cover it directly, it is easy and convenient to carry and use.",
				7016.0,
				5,
				image6,
				subCategory3,
				System.currentTimeMillis(),
				System.currentTimeMillis())
			);
			articleService.saveArticle(new Article(
				null,
				"Mobilier De Bureau 1.20M - 3 Tiroir",
				"Les modes de travail évoluent rapidement : espace de coworking, espaces collaboratifs, bureau home office. Les bureaux doivent donc être modulaires pour répondre à ces nouveaux modes.",
				117500.0,
				5,
				image7,
				subCategory4,
				System.currentTimeMillis(),
				System.currentTimeMillis())
			);
			Article article = articleService.saveArticle(new Article(
				null,
				"Table Pliante Portable Pour Ordinateur Ou Le Petit Déj",
				"Matériau : panneau de particules de bois massif et tube en alliage d'aluminium. Couleur : multi Dimensions du bureau : 60 x 40 x 28 cm.Poids : 3 kg. \n" +
						"Table de Lit Haut Qualité: Fabriqué en MDF et en acier, ce qui rend la table d'ordinateur portable étude et assez solide pour l'utiliser. Le matériau soigneusement sélectionné garantit sa longue durée de vie. \n" +
						"Le plateau de lit pour ordinateur portable est un excellent ajout à n'importe quel lit, canapé, canapé ou chaise. Le plateau vous permet de manger ou de travailler sur votre ordinateur portable dans le confort de votre propre lit. \n" +
						"Design pliable : pieds pliables pour un rangement peu encombrant, espace de rangement supplémentaire pour livres et stylos. \n" +
						"Utilisé conjointement avec un bureau normal, il vous permet de travailler debout et de vous libérer des troubles tels que les maux de dos et la spondylarthrite causés par de longues heures assis sur le lieu de travail \n" +
						"La fente pour carte de bureau empêche la nourriture ou les ordinateurs portables de tomber et fait un lit désordonné. Vous pouvez regarder des films ou la télévision dans des emplacements spéciaux sur votre bureau. Pas besoin de tenir. Et le plateau de la table est équipé d'un porte-gobelet, même si le gobelet à eau est placé, il n'y a aucune crainte de renversement. C'est confortable et facile.",
				18000.0,
				5,
				image8,
				subCategory4,
				System.currentTimeMillis(),
				System.currentTimeMillis())
			);


			// cart
			Cart cart = userService.saveCart(new Cart(null, article, 3));
			List<Cart> carts = new ArrayList<>();
			carts.add(cart);

			// auth

			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveUser(new AppUser(
				null,
				"david",
				"abraham",
				"davidbryster@gmail.com",
				"davidbryst",
				"Bryster-17",
				System.currentTimeMillis(),
				System.currentTimeMillis(),
				carts,
				new ArrayList<>())
			);
			userService.saveUser(new AppUser(
				null,
				"ouattara",
				"ali",
				"bryst@gmail.com",
				"bryst",
				"123",
				System.currentTimeMillis(),
				System.currentTimeMillis(),
				new ArrayList<>(),
				new ArrayList<>())
			);

			userService.addRoleToUser("davidbryst", "ROLE_USER");
			userService.addRoleToUser("bryst", "ROLE_USER");
		};
	}
}
