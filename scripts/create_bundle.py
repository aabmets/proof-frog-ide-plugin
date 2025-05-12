import os
import tomllib
import subprocess
from packaging import tags


def main():
    with open('../proof_frog/pyproject.toml', 'rb') as f:
        project = tomllib.load(f)['project']
        proj_name = project['name']
        proj_version = project['version']

    first_tag = list(tags.sys_tags())[0]
    platform = first_tag.platform

    if 'GITHUB_ENV' in os.environ:
        with open(os.environ['GITHUB_ENV'], 'a') as f:
            artifact_name = f"{proj_name}-{proj_version}-{platform}"
            f.write(f"artifact_name={artifact_name}\n")
            f.write(f"proof_frog_version={proj_version}\n")

    subprocess.run([
        'pyinstaller',
        '--onedir',
        '--paths', '.',
        '--collect-all', 'antlr4_python3_runtime',
        '--collect-all', 'colorama',
        '--collect-all', 'sympy',
        '--collect-all', 'z3_solver',
        '--collect-all', 'z3',
        '--name', proj_name,
        'bundle_wrapper.py'
    ], check=True)


if __name__ == "__main__":
    main()
