pipeline
{
	stages
	{
		stage('Building jar')
		{
			bat "mvn clean package -DskipTests"
		}

		stage('Building image')
		{
			bat "docker build -t attbatch1/buildimagethroughjenkins"
		}

		stage('Push Image')
		{
			bat "docker push attbatch1/buildimagethroughjenkins"
		}
	}
}