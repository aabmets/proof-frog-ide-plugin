# proof-frog-ide-plugin
ProofFrog DSL Plugin for JetBrains IDE-s

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