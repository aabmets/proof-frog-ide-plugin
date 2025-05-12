import os
import tomllib
import subprocess
import shutil
from packaging import tags
from pathlib import Path


def main():
    scripts_dir = Path(__file__).parent
    project_toml = scripts_dir.parent / 'proof_frog' / 'pyproject.toml'
    project = tomllib.load(project_toml.open('rb'))['project']
    proj_name = project['name']
    proj_version = project['version']

    if 'GITHUB_OUTPUT' in os.environ:
        with open(os.environ['GITHUB_OUTPUT'], 'a') as out:
            out.write(f"proof_frog_version={proj_version}\n")

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

    dist_dir = scripts_dir / 'dist'
    artifacts_dir = scripts_dir / 'artifacts'
    artifacts_dir.mkdir(parents=True, exist_ok=True)

    first_tag = list(tags.sys_tags())[0]
    platform = first_tag.platform
    archive_name = f"{proj_name}-{proj_version}-{platform}"

    shutil.make_archive(
        base_name=str(artifacts_dir / archive_name),
        format='zip',
        root_dir=str(dist_dir),
        base_dir=proj_name
    )


if __name__ == "__main__":
    main()
