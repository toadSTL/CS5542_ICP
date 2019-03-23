# ICP 7

### Objectives

  - Create a K-Means and Expectation Maximization Models with text dataset of our reference samples

### Implementation

Below are screenshots of the Analysis of the KM and EM models:
![kMeans Classes](https://github.com/toadSTL/CS5542_ICP/blob/master/ICP6/doc/kMeansClusteringAnalysis.png)
![Expectation Maximization Classes](https://github.com/toadSTL/CS5542_ICP/blob/master/ICP6/doc/ExpectationMaximizationClusteringAnalysis.png)

As shown both clustering schemes result in asymetric clusters.  The clusters in the k-means model tend to contain very similar samples, while the clusters in the expectation maximizatin model are more varied (however this is largely because the Expectation Maximization models only clusters samples into two classes, where for the k-means clustering we have elected to cluster the samples into 10 classes).  Still the similarity between the samples clustered together using expectation maximization is substantial, but this (as well as the high intra-cluster similarity for k-mean) can at least be partially explained by the high degree of homogoneity of the samples.

