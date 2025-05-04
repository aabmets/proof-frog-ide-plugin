# ProofFrog Plugin for JetBrains IDE-s

## Description
**[ProofFrog](https://github.com/ProofFrog/ProofFrog)** is a work-in-progress tool for verifying cryptographic game-hopping proofs.  
All security properties in ProofFrog are written via pairs of indistinguishable games.

This plugin provides syntax highlighting, annotations, code completion, and other features   
for the ProofFrog [Domain Specific Language](https://en.wikipedia.org/wiki/Domain-specific_language), which is described in detail in the [thesis paper](https://dspacemainprd01.lib.uwaterloo.ca/server/api/core/bitstreams/b0056349-bcb8-4d69-8b45-dd3808e945d0/content).


## Development

This plugin must be developed with IntelliJ IDEA IDE (Community or Ultimate).  
Development of this plugin requires the following plugins from the IDE marketplace:  

* `ANTLRv4`
* `Grammar-Kit` 
* `Index-Viewer` 
* `Psi-Viewer`
* `Plugin DevKit`

Do once per IDE:  
In the top navbar, go to `Help -> Edit Custom Properties...` and insert  
`idea.is.internal=true` into the `idea.properties` file, if it's not there yet.

To pull in ProofFrog examples from the nested submodule, run these commands:
```shell
cd proof_frog
git submodule set-url examples https://github.com/ProofFrog/examples.git
git submodule sync
cd ..
git submodule update --init --recursive
```

Let sources root equal `src/main/java/io/github/aabmets/prooffroglang`.  
To modify the syntax rules of this plugin, modify `ProofFrog.bnf` and `ProofFrog.flex` in sources root.

Then in `ProofFrog.bnf` context menu select `Generate Parser Code`  
and in `ProofFrog.flex` context menu select `Run JFlex Generator`,  
then implement the generated changes into these files:

* `<sources root>/ProofFrogSyntaxHighlighter.java`
* `<sources root>/ProofFrogColorSettingsPage.java`
* `<sources root>/psi/ProofFrogTokenSets.java`
