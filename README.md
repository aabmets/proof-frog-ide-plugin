# ProofFrog Plugin for JetBrains IDE-s

## Description
**[ProofFrog](https://github.com/ProofFrog/ProofFrog)** is a work-in-progress tool for verifying cryptographic game-hopping proofs.  
All security properties in ProofFrog are written via pairs of indistinguishable games.

This plugin aims to provide syntax highlighting, annotations, code completion, and other features   
for the ProofFrog [Domain Specific Language](https://en.wikipedia.org/wiki/Domain-specific_language), which is described in detail in the [thesis paper](https://dspacemainprd01.lib.uwaterloo.ca/server/api/core/bitstreams/b0056349-bcb8-4d69-8b45-dd3808e945d0/content).

<br/>
<img src="media/proof_file.png" alt="proof_file.png" width="80%"/>
<br/>


## Current Features

1) Syntax validation
2) Syntax highlighting
3) Pretty printed syntax errors
4) Color settings menu
5) Comment with Line Comment action
6) Automatic downloading of platform-specific ProofFrog binaries
7) Context menu for checking and verifying files with ProofFrog
8) Run configurations
9) Ctrl+Click of import statement file paths (references)

<a href="#prooffrog-plugin-for-jetbrains-ide-s"><small>⬆️ Back to top</small></a>
<br/>


## Roadmap

If you want these goals to get done, then please ⭐ Star this repository to indicate your need for  
this software. You can also participate in the [discussions](https://github.com/aabmets/proof-frog-ide-plugin/discussions) 
to propose other features for the ProofFrog  
plugin or make a pull request against this repository with your implemented changes.

1) General reference contributor
2) Completion contributor
3) Go To Symbol contributor
4) Find usages provider
5) Folding builder

<a href="#prooffrog-plugin-for-jetbrains-ide-s"><small>⬆️ Back to top</small></a>
<br/>


## Parser Differences

There is a minor difference in how this plugin parses ProofFrog code compared to the ProofFrog library itself.  
Namely, this plugin **does not** and **will not** allow the keyword `in` as class field names, so you might get parsing  
errors when opening some ProofFrog example files which contain `Int in = in;` or `requires F.in == F.out;`.  
This syntax is forbidden because literally all real programming languages forbid the usage of reserved keywords  
as identifiers, and it does not make sense to deviate from this standard.

<a href="#prooffrog-plugin-for-jetbrains-ide-s"><small>⬆️ Back to top</small></a>
<br/>


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
 
To modify the syntax rules of this plugin, modify the `ProofFrog.bnf` and `ProofFrog.flex` files in  
sources root directory at `src/main/java/io/github/aabmets/prooffroglang`.

Then in `ProofFrog.bnf` context menu select `Generate Parser Code` and in `ProofFrog.flex` context menu  
select `Run JFlex Generator`, then use the generated PSI elements in any number of ProofFrog source files  
to implement the plugin behavior:

<a href="#prooffrog-plugin-for-jetbrains-ide-s"><small>⬆️ Back to top</small></a>
<br/>
