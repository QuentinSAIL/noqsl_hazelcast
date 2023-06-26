# Guide d'installation du projet

## Vérifier et installer Java

1. Pour vérifier si Java est installé, ouvrez une fenêtre de terminal et tapez :
    ```
    java -version
    ```
    Si une version de Java est installée, la version actuelle s'affiche. Vérifiez si la version est 19.0.2. Si ce n'est pas le cas, ou si Java n'est pas installé, continuez avec les étapes suivantes pour l'installation.

2. Allez sur le [site Web d'Oracle](https://www.oracle.com/java/technologies/javase-jdk19-downloads.html) pour télécharger le JDK 19.0.2.

3. Sélectionnez le bon fichier pour votre système d'exploitation et votre architecture (Windows, macOS, Linux, etc.), téléchargez-le et suivez les instructions d'installation.

## Installation de Hazelcast

1. Assurez-vous que vous avez une connexion Internet active.

2. Hazelcast est fourni comme une dépendance dans votre projet Maven. Il sera donc automatiquement téléchargé et installé lorsque vous construirez votre projet. Vous n'avez pas besoin de l'installer manuellement.

## Cloner le repo Github

1. Si vous ne l'avez pas déjà fait, installez Git. Vous pouvez le télécharger à partir de ce [lien](https://git-scm.com/downloads). Suivez les instructions pour votre système d'exploitation spécifique.

2. Pour cloner le dépôt, ouvrez un terminal, allez dans le répertoire où vous voulez que le code soit téléchargé, et tapez :
    ```
    git clone url_du_repo
    ```
    Remplacez "url_du_repo" par l'URL du dépôt Github que vous voulez cloner.

## Utiliser Maven dans IntelliJ IDEA

1. Ouvrez IntelliJ IDEA et cliquez sur "Open" pour ouvrir le projet que vous avez cloné.

2. Assurez-vous que votre projet utilise le bon JDK (19.0.2) en allant dans File -> Project Structure -> Project Settings -> Project.

3. Maven devrait être déjà intégré dans IntelliJ IDEA. Vous pouvez voir le panneau Maven à droite. Si vous ne le voyez pas, allez dans View -> Tool Windows -> Maven.

4. Dans le panneau Maven, cliquez sur le bouton "Reload All Maven Projects" en haut à gauche pour télécharger toutes les dépendances nécessaires (y compris Hazelcast).

5. Une fois que toutes les dépendances sont téléchargées, vous pouvez compiler le projet en cliquant sur "Lifecycle" -> "install". Ceci compile le code source et crée un fichier JAR.

6. Pour exécuter le projet, allez dans le menu Run -> Run 'Main'. Le projet doit maintenant se lancer et s'exécuter.


## Visualisation des données avec Hazelcast Management Center (pas obligatoire)
Hazelcast fournit un outil de gestion appelé Hazelcast Management Center qui vous permet de surveiller et de gérer vos clusters de Hazelcast. Vous pouvez également l'utiliser pour visualiser les données stockées dans Hazelcast.

Voici comment l'utiliser :

Téléchargez Hazelcast Management Center à partir du site officiel de Hazelcast : https://hazelcast.com/open-source-projects/downloads/. Sélectionnez "Hazelcast IMDG", puis "Management Center".

Extrayez le fichier zip téléchargé.

Ouvrez une fenêtre de terminal/commande et naviguez vers le dossier que vous venez d'extraire.

Exécutez la commande suivante pour démarrer Hazelcast Management Center :

Si vous êtes sur Windows, la commande serait :
```
 bin\mc-start.cmd
```
Maintenant, il faut se connecter au cluster. Pour connaitre l'adresse du cluster lancez le programme java et a la fin si tout a bien fonctionne les informations du cluster seront affiché.

Par défaut, l'adresse serait http://localhost:5701. Cliquez sur "Connect" pour se connecter au cluster.
