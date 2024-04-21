1. 生成jmod文件
   
   ```shell
   jmod create --class-path target/classes ^ （字节码路径）
        --main-class cn.mycz.spectrum.MainApplication ^ （主类名）
        output-17/jmods/spectrum.jmod（文件名）
   ```

2. 生成运行时

   ```shell
   jlink --module-path output-17/jmods ^ （jmod路径）
       --add-modules cn.mycz.spectrum ^  （模块名）
       --output output-17/runtime ^ （生成的文件存放路径）
       --launcher launcher=cn.mycz.spectrum （是否生成launcher）
   ```

3. 生成镜像

   ```shell
   jpackage --type app-image ^
           -n image ^
           -d output-17 ^
           -p output-17/jmod ^
           -m cn.mycz.spectrum/cn.mycz.spectrum.
   ```
