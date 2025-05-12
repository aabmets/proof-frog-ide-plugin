pyinstaller `
    --onedir `
    --paths . `
    --collect-all antlr4_python3_runtime `
    --collect-all colorama `
    --collect-all sympy `
    --collect-all z3_solver `
    --collect-all z3 `
    --name proof_frog `
    proof_frog_wrapper.py
