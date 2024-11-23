mjml:
    rm -rf src/main/resources

    npx esbuild src/main/js/mjml.js \
      --format=esm \
      --outdir=src/main/resources/dev/mccue/mjml \
      --bundle \
      --target=es2022